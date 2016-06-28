package com.example.timingtest;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv1;
	private Button btn1;
	private Button newActivityBtn;

	private static final int _android_accounts_AccountManager_getAccounts = 0;
	private static final int _android_content_ContentResolver_acquireContentProviderClient = 1;
	private static final int _android_content_ContentResolver_delete = 2;
	private static final int _android_content_ContentResolver_getType = 3;
	private static final int _android_content_ContentResolver_insert = 4;
	private static final int _android_content_ContentResolver_openAssetFileDescriptor = 5;
	private static final int _android_content_ContentResolver_openInputStream = 6;
	private static final int _android_content_ContentResolver_query = 7;
	private static final int _android_content_ContentResolver_update = 8;
	private static final int _android_content_ContentWrapper_getContentResolver = 9;
	private static final int _android_content_ContentResolver_acquireUnstableContentProviderClient = 10;
	private static final int _android_util_base64_decode = 11;
	private static final int _android_util_base64_encode = 12;
	private static final int _android_util_base64_encodeToString = 13;
	private static final int _dalvick_system_DexClassLoader_findLibrary = 14;
	private static final int _java_lang_system_loadLibrary = 15;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv1 = (TextView) findViewById(R.id.tv1);
		btn1 = (Button) findViewById(R.id.btn1);
		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				long sum = Test.test(MainActivity.this);
//				long sum = timingApi(14);
				System.out.println("" + sum);
			}
		});
		
		findViewById(R.id.start_activity).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				startActivity(intent);
			}
		});

	}

	private long timingApi(int name) {
		switch (name) {
		case _android_accounts_AccountManager_getAccounts:
			return AndroidAccountsAccountManager.callGetAccounts(this);
		case _android_content_ContentResolver_acquireContentProviderClient:
			return AndroidContentContentResolver.callAcquireContentProviderClient(this);
		case _android_content_ContentResolver_delete:
			return AndroidContentContentResolver.callDelete(this);
		case _android_content_ContentResolver_getType:
			return AndroidContentContentResolver.callGetType(this);
		case _android_content_ContentResolver_insert:
			return AndroidContentContentResolver.callInsert(this);
		case _android_content_ContentResolver_openAssetFileDescriptor:
			return AndroidContentContentResolver.callOpenAssetFileDescriptor(this);
		case _android_content_ContentResolver_openInputStream:
			return AndroidContentContentResolver.callOpenInputStream(this);
		case _android_content_ContentResolver_query:
			return AndroidContentContentResolver.callQuery(this);
		case _android_content_ContentResolver_update:
			return AndroidContentContentResolver.callUpdate(this);
		case _android_content_ContentWrapper_getContentResolver:
			return AndroidContentContextWrapper.callGetContentResolver(this);
		case _android_content_ContentResolver_acquireUnstableContentProviderClient:
			return AndroidContentContentResolver.callAcquireUnstableContentProviderClient(this);
		case _android_util_base64_decode:
			return AndroidUtilBase64.callDecode();
		case _android_util_base64_encode:
			return AndroidUtilBase64.callEncode();
		case _android_util_base64_encodeToString:
			return AndroidUtilBase64.callEncodeToString();
		case _dalvick_system_DexClassLoader_findLibrary:
			return DalvikSystemDexClassLoader.callFindLibrary(this);
		case _java_lang_system_loadLibrary:
			return JavaLangSystem.callLoadLibrary();
		default:
			return 0l;
		}
	}
}
