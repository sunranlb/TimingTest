package com.example.timingtest;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;

public class AndroidAccountsAccountManager {
	public static long callGetAccounts(Context c) {
		AccountManager am = AccountManager.get(c);
		long b = System.nanoTime();
		am.getAccounts();
		long e = System.nanoTime();
		return e - b;
	}
}
