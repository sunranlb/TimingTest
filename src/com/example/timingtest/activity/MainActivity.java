package com.example.timingtest.activity;

import com.example.timingtest.R;
import com.example.timingtest.util.FileIOHelper;
import com.example.timingtest.util.TimeStampUilts;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
 * startActivity
 */
public class MainActivity extends Activity{

	private TextView SDCardInfoTV;
	private Button startBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SDCardInfoTV = (TextView) findViewById(R.id.tv1);
		startBtn = (Button) findViewById(R.id.btn1);
		
		//is SDcard exists???
		if(FileIOHelper.isSdCardExist()){
			SDCardInfoTV.setText("SDcard path:" + FileIOHelper.getSdCardPath());
		} else {
			SDCardInfoTV.setText("SDcard not found!!!");
			SDCardInfoTV.setTextColor(Color.RED);
			startBtn.setClickable(false);
		}
		
		startBtn.setOnClickListener(new View.OnClickListener() {
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
