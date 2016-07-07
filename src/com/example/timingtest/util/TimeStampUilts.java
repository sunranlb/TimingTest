package com.example.timingtest.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.http.impl.conn.Wire;

import android.os.Environment;
import android.util.Log;

public class TimeStampUilts {

	private static final String TAG = "TimeStamp";
	private static HashMap<String, Long> sApiNameMap = new HashMap<String, Long>(); 

	public static long stampBeforeApi(String apiName) {
		long timeBefore = System.nanoTime();
		sApiNameMap.put(apiName, timeBefore);
		Log.d(TAG, apiName + "前:\t" + timeBefore);
		return timeBefore;
	}

	public static long stampAfterApi(String apiName) {
		long timeAfter = System.nanoTime();
		Log.d(TAG, apiName + "后:\t" + timeAfter);
		if (sApiNameMap.containsKey(apiName)) {
			long timeBefore = sApiNameMap.get(apiName);
			sApiNameMap.remove(apiName);
			calTimeDiff(apiName, timeAfter, timeBefore);
		}		
		return timeAfter;
	}

	public static long calTimeDiff(String apiName, long timeAfter, long timeBefore) {
		long diff = timeAfter - timeBefore;
		if (diff == 0) {
			Log.e(TAG, apiName + "的时间差为0");
			return 0;
		}
		Log.d(TAG, apiName + " diff:\t" + diff);
		FileIOHelper helper = FileIOHelper.getInstance();
		helper.writeToFile(apiName + "'s time diff is: \t" + diff + "\n");
		return diff;
	}
}
