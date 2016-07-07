package com.example.timingtest.activity;

import com.example.timingtest.R;
import com.example.timingtest.util.TimeStampUilts;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
 * startActivity
 */
public class MainActivity extends Activity{

	private TextView tv1;
	private Button btn1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv1 = (TextView) findViewById(R.id.tv1);
		btn1 = (Button) findViewById(R.id.btn1);
		
		//is SDcard exists???
		if(isSdCardExist()){
			tv1.setText("SDcard path:"+getSdCardPath());
		} else {
			tv1.setText("SDcard not found!!!");
			tv1.setTextColor(Color.RED);
			btn1.setClickable(false);
		}
		
		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				TimeStampUilts.init();
				
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				TimeStampUilts.stampBeforeApi("startActivity");
				startActivity(intent);
				TimeStampUilts.stampAfterApi("startActivity");
			}
		});
		
	}

	/** 
	 * 判断SDCard是否存在 [当没有外挂SD卡时，内置ROM也被识别为存在sd卡] 
	 *  
	 * @return 
	 */  
	public boolean isSdCardExist() {  
	    return Environment.getExternalStorageState().equals(  
	            Environment.MEDIA_MOUNTED);  
	} 
	
	/** 
	 * 获取SD卡根目录路径 
	 *  
	 * @return 
	 */  
	public String getSdCardPath() {  
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
