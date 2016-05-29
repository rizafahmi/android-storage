package com.example.savelogin;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText usernameEditText;
	private EditText passwordEditText;
	private TextView dataTextView;
	private FileOutputStream fos;
	private String FILENAME = "UserInfo";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		usernameEditText = (EditText) findViewById(R.id.usernameEditText);
		passwordEditText = (EditText) findViewById(R.id.passwordEditText);
		dataTextView = (TextView) findViewById(R.id.dataTextView);
		
		SharedPreferences pref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

		usernameEditText.setText(pref.getString("username", ""));
		passwordEditText.setText(pref.getString("password", ""));
		
//		
//		try {
//			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
//			fos.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
 	}
	
	public void savePref(View view) {
		SharedPreferences pref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
		
		SharedPreferences.Editor editor = pref.edit();
		editor.putString("username", usernameEditText.getText().toString());
		editor.putString("password", passwordEditText.getText().toString());
		
		editor.apply();
		
		String data = usernameEditText.getText().toString() + ":" + passwordEditText.getText().toString();		
		// Save to internal storage
		try {
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.write(data.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
	}
	
	public void loadPref(View view) {
		SharedPreferences pref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

		String username = pref.getString("username", "");
		String password = pref.getString("password", "");
		
		dataTextView.setText(username + ":" + password);
	}
	
	
}
