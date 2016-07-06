package com.example.timingtest.independent;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.example.timingtest.dex.DexHelper;
import com.example.timingtest.util.TimeStampUilts;

import android.content.Context;
import android.os.Environment;
import dalvik.system.DexClassLoader;

public class JavaLangClassloader {
	public static long callLoadClass(Context c) {
		long b = 0, e = 0;
		DexHelper.CopyAssertJarToFile(c, "testdex.jar", "testdex.jar");
		File file = new File(Environment.getExternalStorageDirectory()
				.toString() + File.separator + "testdex.jar");
		final File optimizedDexOutputPath = c.getDir("temp", Context.MODE_PRIVATE);
		DexClassLoader classLoader = new DexClassLoader(file.getAbsolutePath(),
				optimizedDexOutputPath.getAbsolutePath(), null,
				c.getClassLoader());
		try {
			TimeStampUilts.stampBeforeApi("loadClass");
			Class<?> iclass = classLoader.loadClass("DexTest.DexHello");
			TimeStampUilts.stampAfterApi("loadClass");
			//以下用于检测加载成功性
			Constructor<?> istructor = iclass.getConstructor(Context.class);
			Method method = iclass.getMethod("hello", null);
			String data = (String) method.invoke(istructor.newInstance(c),
					null);
			System.out.println("data = "+data);
		} catch (Exception ee) {
			// TODO Auto-generated catch block
			ee.printStackTrace();
		}
		b = System.nanoTime();
		e = System.nanoTime();
		return e - b;
	}
}
