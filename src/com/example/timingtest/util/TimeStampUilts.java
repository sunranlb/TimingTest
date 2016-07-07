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

	private static long sTimeStampBefore;
	private static long sTimeStampAfter;
	private final static String FILE_NAME = "r.txt";
	private static File targetFile;
	private static RandomAccessFile raf;
	private static HashMap<String,Long> apiBeforeStampMap = new HashMap<String,Long>(); 

	public static void init() {
		try {
			targetFile = new File(Environment.getExternalStorageDirectory()
					.getCanonicalPath() + "/"+FILE_NAME);
			raf = new RandomAccessFile(targetFile, "rw");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static long stampBeforeApi(String apiName) {
		sTimeStampBefore = System.nanoTime();
		apiBeforeStampMap.put(apiName, sTimeStampBefore);
		Log.d(TAG, apiName + "前：\t" + sTimeStampBefore);
		return sTimeStampBefore;
	}

	public static long stampAfterApi(String apiName) {
		sTimeStampAfter = System.nanoTime();
		Log.d(TAG, apiName + "后：\t" + sTimeStampAfter);
		long diff = calTimeDiff(apiName,sTimeStampAfter);
		if(diff==0)return 0;
		else writeToFile(apiName+":"+diff+"\n");
		return sTimeStampAfter;
	}

	public static long calTimeDiff(String apiName,long timeAfter) {
		if(!apiBeforeStampMap.containsKey(apiName)){
			return 0;
		} else {
			long timeBefore = apiBeforeStampMap.get(apiName);
			long diff = timeAfter - timeBefore;
			apiBeforeStampMap.remove(apiName);
			return diff;
		}
	}

	private static void writeToFile(String s) {
		try {
			raf.seek(targetFile.length());
			raf.write(s.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
