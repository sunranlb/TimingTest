package com.example.timingtest.activity;

import com.example.timingtest.util.TimeStampUilts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/*
 * getBundleExtra
 * getData
 * getAction
 * 
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		TimeStampUilts.stampBeforeApi("getBundleExtra");
		intent.getBundleExtra("bundle");
		TimeStampUilts.stampAfterApi("getBundleExtra");
		
		TimeStampUilts.stampBeforeApi("getData");
		intent.getData();
		TimeStampUilts.stampAfterApi("getData");
		
		TimeStampUilts.stampBeforeApi("getAction");
		intent.getAction();
		TimeStampUilts.stampAfterApi("getAction");
	}
}
