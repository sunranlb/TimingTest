package com.example.timingtest.dex;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import android.content.Context;
import android.os.Environment;

public class DexHelper {
	public static void CopyAssertJarToFile(Context context, String filename,
			String des) {
		try {

			File file = new File(Environment.getExternalStorageDirectory()
					.toString() + File.separator + des);
			if (file.exists()) {
				System.out.println("DexHelper:dex file exists!!");
				return;
			}

			InputStream inputStream = context.getAssets().open(filename);
			file.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			byte buffer[] = new byte[1024];
			int len = 0;
			while ((len = inputStream.read(buffer)) > 0) {
				fileOutputStream.write(buffer, 0, len);
			}
			fileOutputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
