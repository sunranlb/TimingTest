package com.example.timingtest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

import DexTest.DexHello;
import android.content.Context;
import android.os.Environment;
import android.util.Base64;
import android.widget.Toast;

public class Test {
	public static long test(Context c) {
		long b = 0, e = 0;
		File tmp = new File(System.getProperty("java.library.path"));
		System.out.println("【"+System.getProperty("usr.dir"));
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
