package com.example.timingtest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URI;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

import DexTest.DexHello;
import DexTest.DexHelper;
import android.content.Context;
import android.os.Environment;
import android.util.Base64;
import android.widget.Toast;

public class Test {
	public static long test(Context c) {
		long b = 0, e = 0;
		DexHelper.CopyAssertJarToFile(c, "testdex.jar", "testdex.jar");
		File file = new File(Environment.getExternalStorageDirectory()
				.toString() + File.separator + "testdex.jar");
		final File optimizedDexOutputPath = c.getDir("temp", Context.MODE_PRIVATE);
		DexClassLoader classLoader = new DexClassLoader(file.getAbsolutePath(),
				optimizedDexOutputPath.getAbsolutePath(), null,
				c.getClassLoader());
		try {
			Class<?> iclass = classLoader.loadClass("DexTest.DexHello");
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
