package com.example.villagesoft;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button btn_login;
	private EditText edit_username;
	private EditText edit_password;
	private CheckBox cb_remeber;
	private CheckBox cb_auto;
	private SharedPreferences sp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		sp = getSharedPreferences("user", MODE_WORLD_READABLE);
		if (sp.getBoolean("AutoSign", false)) {
			if (check(sp.getString("username", "1"), sp.getString("password", "11"))) {
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, FristPage.class);
				startActivity(intent);
			}
		} else {
			initView();
		}
		btn_login = (Button) findViewById(R.id.bnLogin);
		btn_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				edit_username = (EditText) findViewById(R.id.userNameText);
				edit_password = (EditText) findViewById(R.id.passwdText);
				cb_remeber = (CheckBox) findViewById(R.id.cb_remeber);
				cb_auto = (CheckBox) findViewById(R.id.cb_auto);
				String username = edit_username.getText().toString();
				String password = edit_password.getText().toString();
				Editor editor = sp.edit();
				if (cb_remeber.isChecked()) {
					editor.putString("username", username);
					editor.putString("password", password);
				}
				editor.commit();
				if (check(username, password)) {
					if (cb_auto.isChecked()) {
						editor.putBoolean("AutoSign", true).commit();
					}
					editor.commit();
					Intent intent = new Intent();
					intent.setClass(MainActivity.this, FristPage.class);
					startActivity(intent);
				} 
				else {
					editor.putBoolean("AutoSign", false).commit();
					Toast.makeText(getApplicationContext(), "error:µÇÂ½Ê§°Ü", Toast.LENGTH_LONG).show();;
				}
			}
		});
	}

	public void initView() {
		edit_username = (EditText) findViewById(R.id.userNameText);
		edit_password = (EditText) findViewById(R.id.passwdText);
		cb_remeber = (CheckBox) findViewById(R.id.cb_remeber);
		cb_auto = (CheckBox) findViewById(R.id.cb_auto);

		edit_username.setText(sp.getString("username", ""));
		edit_password.setText(sp.getString("password", ""));
	}

	public boolean check(String username, String password) {
		boolean flag = false;
		if (username.equals(password)) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		} else if (id == R.id.register) {
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, Resgiter.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}
}
