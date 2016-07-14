package com.example.timingtest.independent;

import java.io.File;

import com.example.timingtest.util.TimeStampUilts;

import android.content.Context;
import dalvik.system.PathClassLoader;
/*
 * DexClassLoader.findLibrary
 */
public class DalvikSystemDexClassLoader {
	public static void callFindLibrary(Context c) {
		File tmp = new File(System.getProperty("java.io.tmpdir"));
		File aplp = new File(tmp, "applicationLibPath");
		PathClassLoader pcl = new PathClassLoader(
				aplp.toString(), aplp.toString(),
				c.getClass().getClassLoader());
		
		TimeStampUilts.stampBeforeApi("DexClassLoader.findLibrary");
		pcl.findLibrary("duplicated");
		TimeStampUilts.stampAfterApi("DexClassLoader.findLibrary");
	}
}
