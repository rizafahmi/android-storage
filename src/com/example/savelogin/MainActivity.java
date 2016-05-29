package com.example.savelogin;

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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		usernameEditText = (EditText) findViewById(R.id.usernameEditText);
		passwordEditText = (EditText) findViewById(R.id.passwordEditText);
		dataTextView = (TextView) findViewById(R.id.dataTextView);
 	}
	
	public void savePref(View view) {
		SharedPreferences pref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
		
		SharedPreferences.Editor editor = pref.edit();
		editor.putString("username", usernameEditText.getText().toString());
		editor.putString("password", passwordEditText.getText().toString());
		
		editor.apply();
		
		Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();
	}
	
	public void loadPref(View view) {
		SharedPreferences pref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

		String username = pref.getString("username", "");
		String password = pref.getString("password", "");
		
		dataTextView.setText(username + ":" + password);
	}
	
	
}
