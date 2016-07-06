package com.example.timingtest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/*
 * getBooleanArrayExtra
 * getData
 * getAction
 * 
 */
public class MyBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		System.out.println("" + intent.getBooleanArrayExtra("name") + ","
				+ intent.getData() + "," + intent.getAction());
		intent.getBooleanArrayExtra("name");
		intent.getData();
		intent.getAction();
	}
}
