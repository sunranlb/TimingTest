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
	
	//TODO 其余声明周期 ；manifest中没加该activity
	
}
