package com.example.timingtest;

import java.io.File;

import android.content.Context;
import dalvik.system.PathClassLoader;

public class DalvikSystemDexClassLoader {
	public static long callFindLibrary(Context c) {
		long b = 0, e = 0;
		File tmp = new File(System.getProperty("java.io.tmpdir"));
		File applicationLibPath = new File(tmp, "applicationLibPath");
		PathClassLoader pathClassLoader = new PathClassLoader(
				applicationLibPath.toString(), applicationLibPath.toString(),
				c.getClass().getClassLoader());
		b = System.nanoTime();
		pathClassLoader.findLibrary("duplicated");
		e = System.nanoTime();
		return e - b;
	}
}
