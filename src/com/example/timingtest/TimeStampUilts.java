package com.example.timingtest;

import android.util.Log;

public class TimeStampUilts {

	private static final String TAG = "TimeStamp";
	
	private static long sTimeStampBefore;
	private static String sApiNameBefore;
	private static long sTimeStampAfter;
	private static String sApiNameAfter;
	
	public static long stampBeforeApi(String apiName) {
		sTimeStampBefore = System.nanoTime();
		Log.d(TAG, apiName + "ǰ��\t" + sTimeStampBefore);
		sApiNameBefore = apiName;
		return sTimeStampBefore;
	}
	
	public static long stampAfterApi(String apiName) {
		sTimeStampAfter = System.nanoTime();
		Log.d(TAG, apiName + "��\t" + sTimeStampAfter);
		sApiNameAfter = apiName;
		calTimeDiff();
		return sTimeStampAfter;
	}
	
	public static long calTimeDiff() {
		if (sApiNameAfter.equals(sApiNameBefore)) {
			long diff = sTimeStampAfter - sTimeStampBefore;
			Log.d(TAG, sApiNameAfter + "ʱ��\t" + diff);
			return diff;
		}
		return 0;
	}
	
	
}
