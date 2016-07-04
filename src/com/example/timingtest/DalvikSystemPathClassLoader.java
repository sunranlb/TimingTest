package com.example.timingtest;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import dalvik.system.PathClassLoader;

import DexTest.DexHelper;
import android.content.Context;
import android.os.Environment;


public class DalvikSystemPathClassLoader {
	public static long callLoadClass(Context c) {
		long b = 0, e = 0;
		
		DexHelper.CopyAssertJarToFile(c, "testdex.jar", "testdex.jar");
		File file = new File(Environment.getExternalStorageDirectory()
				.toString() + File.separator + "testdex.jar");
		
		PathClassLoader pcl = new PathClassLoader(file.getAbsolutePath(),
				file.getAbsolutePath(), c.getClass().getClassLoader());
		
		try {
			TimeStampUilts.stampBeforeApi("loadClass");
			Class<?> iclass = pcl.loadClass("DexTest.DexHello");
			TimeStampUilts.stampAfterApi("loadClass");
			Constructor<?> istructor = iclass.getConstructor(Context.class);
			Method method = iclass.getMethod("hello", null);
			String data = (String) method.invoke(istructor.newInstance(c),
					null);
			System.out.println("data = "+data);
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		
		
		b = System.nanoTime();
		e = System.nanoTime();
		return e - b;
	}


}
