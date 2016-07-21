package com.example.timingtest.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.os.Environment;
import android.util.Log;

/**
 * 单例
 * @author sang
 */
public class FileIOHelper {

	private static final String TAG = "FileIOHelper";
	private static final String FILE_NAME = "TimingTestData.txt";
	private static FileIOHelper instance;
	private File targetFile;
	private RandomAccessFile raf;
	
	private FileIOHelper() {
		try {
			targetFile = new File(Environment.getExternalStorageDirectory()
					.getCanonicalPath() + "/" + FILE_NAME);
			raf = new RandomAccessFile(targetFile, "rw");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static FileIOHelper getInstance() {
		if (instance == null) {
			instance = new FileIOHelper();
		}
		return instance;
	}
	
	public void writeToFile(String str) {
		try {
			if (raf == null) {
				Log.e(TAG, "存储失败 ： RandomAccessFile is null");
				return;
			}
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd H:m:s");
			raf.seek(targetFile.length());
			String in = format.format(new Date()) + "\t" + str;
			raf.write(in.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** 
	 * 判断SDCard是否存在 [当没有外挂SD卡时，内置ROM也被识别为存在sd卡] 
	 */  
	public static boolean isSdCardExist() {  
	    return Environment.getExternalStorageState().equals(  
	            Environment.MEDIA_MOUNTED);  
	} 
	
	/** 
	 * 获取SD卡根目录路径 
	 */  
	public static String getSdCardPath() {  
	    boolean exist = isSdCardExist();  
	    String sdpath = "";  
	    if (exist) {  
	        sdpath = Environment.getExternalStorageDirectory()  
	                .getAbsolutePath();  
	    } else {  
	        sdpath = "不适用";  
	    }  
	    return sdpath;  
	}  
}
