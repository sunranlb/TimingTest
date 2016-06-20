package com.example.timingtest;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv1;
	private Button btn1;

	private static final int _android_accounts_AccountManager_getAccounts = 0;
	private static final int _android_content_ContentResolver_acquireContentProviderClient = 1;
	private static final int _android_content_ContentResolver_delete = 2;
	private static final int _android_content_ContentResolver_getType = 3;
	private static final int _android_content_ContentResolver_insert = 4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv1 = (TextView) findViewById(R.id.tv1);
		btn1 = (Button) findViewById(R.id.btn1);
		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				long sum = timingApi(4);
				System.out.println("" + sum);
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
		default:
			return 0l;
		}
	}
}
