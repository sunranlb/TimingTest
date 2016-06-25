package com.example.timingtest;

import android.app.Activity;
import android.os.Bundle;

public class SecondActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		TimeStampUilts.stampBeforeApi("onCreate");
		super.onCreate(savedInstanceState);
		TimeStampUilts.stampAfterApi("onCreate");
	}
	
	@Override
	protected void onStart() {
		TimeStampUilts.stampBeforeApi("onStart");
		super.onStart();
		TimeStampUilts.stampAfterApi("onStart");
	}
	
	@Override
	protected void onResume() {
		TimeStampUilts.stampBeforeApi("onResume");
		super.onResume();
		TimeStampUilts.stampAfterApi("onResume");
	}
	
	@Override
	protected void onPause() {
		TimeStampUilts.stampBeforeApi("onPause");
		super.onPause();
		TimeStampUilts.stampAfterApi("onPause");
	}
	
	@Override
	protected void onStop() {
		TimeStampUilts.stampBeforeApi("onStop");
		super.onStop();
		TimeStampUilts.stampAfterApi("onStop");
	}
	
	@Override
	protected void onDestroy() {
		TimeStampUilts.stampBeforeApi("onDestroy");
		super.onDestroy();
		TimeStampUilts.stampAfterApi("onDestroy");
	}
	
	@Override
	protected void onRestart() {
		TimeStampUilts.stampBeforeApi("onRestart");
		super.onRestart();
		TimeStampUilts.stampAfterApi("onRestart");
	}
}
