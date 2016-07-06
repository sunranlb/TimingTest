package com.example.timingtest.activity;

import com.example.timingtest.R;
import com.example.timingtest.util.TimeStampUilts;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
 * startActivity
 */
public class MainActivity extends Activity{

	private TextView tv1;
	private Button btn1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv1 = (TextView) findViewById(R.id.tv1);
		btn1 = (Button) findViewById(R.id.btn1);
		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				TimeStampUilts.stampBeforeApi("startActivity");
				startActivity(intent);
				TimeStampUilts.stampAfterApi("startActivity");
			}
		});
		
	}

	

}
