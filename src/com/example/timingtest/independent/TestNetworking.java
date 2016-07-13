package com.example.timingtest.independent;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.example.timingtest.util.TimeStampUilts;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.util.TimingLogger;
/*
 * setWifiEnabled
 * execute
 * Socket
 */
public class TestNetworking {
	public static void callNetworkingApis (Context c){
		WifiManager wifiMNGR = (WifiManager)c.getSystemService(Context.WIFI_SERVICE);
		
		TimeStampUilts.stampBeforeApi("setWifiEnabled");
		wifiMNGR.setWifiEnabled(true);
		TimeStampUilts.stampAfterApi("setWifiEnabled");
		
		String url = "http://10.107.30.80/";
		HttpClient httpClient= new DefaultHttpClient();
		NameValuePair pair1 = new BasicNameValuePair("username", "zds");
        NameValuePair pair2 = new BasicNameValuePair("age", "1");

        try{
        	List<NameValuePair> pairList = new ArrayList<NameValuePair>();
            pairList.add(pair1);
            pairList.add(pair2);
    		HttpEntity requestHttpEntity = new UrlEncodedFormEntity(pairList);
            // URL使用基本URL即可，其中不需要加参数
            HttpPost httpPost = new HttpPost(url);
            // 将请求体内容加入请求中
            httpPost.setEntity(requestHttpEntity);
            // 发送请求
            
            TimeStampUilts.stampBeforeApi("execute");
            HttpResponse response = httpClient.execute(httpPost);
            TimeStampUilts.stampAfterApi("execute");

            
        } catch (Exception e){
        	e.printStackTrace();
        }
        
        try{
        	TimeStampUilts.stampBeforeApi("Socket");
            Socket skt = new Socket("192.168.1.223",9999);
            TimeStampUilts.stampAfterApi("Socket");
        } catch (Exception e){
        	e.printStackTrace();
        }
	}
}
