package com.example.timingtest.independent;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import com.example.timingtest.dex.DexHelper;
import com.example.timingtest.util.TimeStampUilts;

import dalvik.system.PathClassLoader;

import android.content.Context;
import android.os.Environment;
/*
 * PathClassLoader.loadClass
 */
public class DalvikSystemPathClassLoader {
	public static void allLoadClass(Context c) {
		DexHelper.CopyAssertJarToFile(c, "testdex.jar", "testdex.jar");
		File file = new File(Environment.getExternalStorageDirectory()
				.toString() + File.separator + "testdex.jar");
		
		PathClassLoader pcl = new PathClassLoader(file.getAbsolutePath(),
				file.getAbsolutePath(), c.getClass().getClassLoader());
		
		try {
			
			TimeStampUilts.stampBeforeApi("PathClassLoader.loadClass");
			Class<?> iclass = pcl.loadClass("DexTest.DexHello");
			TimeStampUilts.stampAfterApi("PathClassLoader.loadClass");
			
			Constructor<?> istructor = iclass.getConstructor(Context.class);
			Method method = iclass.getMethod("hello", null);
			String data = (String) method.invoke(istructor.newInstance(c),
					null);
			System.out.println("data = "+data);
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}


}
