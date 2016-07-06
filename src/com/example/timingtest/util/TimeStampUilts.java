package com.example.timingtest.util;

import android.util.Log;

public class TimeStampUilts {

	private static final String TAG = "TimeStamp";
	
	private static long sTimeStampBefore;
	private static String sApiNameBefore;
	private static long sTimeStampAfter;
	private static String sApiNameAfter;
	
	public static long stampBeforeApi(String apiName) {
		sTimeStampBefore = System.nanoTime();
		Log.d(TAG, apiName + "前：\t" + sTimeStampBefore);
		sApiNameBefore = apiName;
		return sTimeStampBefore;
	}
	
	public static long stampAfterApi(String apiName) {
		sTimeStampAfter = System.nanoTime();
		Log.d(TAG, apiName + "后：\t" + sTimeStampAfter);
		sApiNameAfter = apiName;
		calTimeDiff();
		return sTimeStampAfter;
	}
	
	public static long calTimeDiff() {
		if (sApiNameAfter.equals(sApiNameBefore)) {
			long diff = sTimeStampAfter - sTimeStampBefore;
			Log.d(TAG, sApiNameAfter + "时间差：\t" + diff);
			return diff;
		}
		return 0;
	}
	
	
}
