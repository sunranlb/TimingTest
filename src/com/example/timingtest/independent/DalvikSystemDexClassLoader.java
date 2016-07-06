package com.example.timingtest.independent;

import java.io.File;

import android.content.Context;
import dalvik.system.PathClassLoader;

public class DalvikSystemDexClassLoader {
	public static long callFindLibrary(Context c) {
		long b = 0, e = 0;
		File tmp = new File(System.getProperty("java.io.tmpdir"));
		File aplp = new File(tmp, "applicationLibPath");
		PathClassLoader pcl = new PathClassLoader(
				aplp.toString(), aplp.toString(),
				c.getClass().getClassLoader());
		b = System.nanoTime();
		pcl.findLibrary("duplicated");
		e = System.nanoTime();
		return e - b;
	}
}
