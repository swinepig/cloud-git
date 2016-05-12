package com.habuma.spitter.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

import net.sf.json.JSONObject;
import net.sf.json.util.JSONTokener;

public class TestWeather {
	
	

	/**
	 * @param urlAll
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果
	 */
	public static String request(String httpUrl, String httpArg) {
	    BufferedReader reader = null;
	    String result = null;
	    StringBuffer sbf = new StringBuffer();
	    httpUrl = httpUrl + "?" + httpArg;

	    try {
	        URL url = new URL(httpUrl);
	        HttpURLConnection connection = (HttpURLConnection) url
	                .openConnection();
	        connection.setRequestMethod("GET");
	        // 填入apikey到HTTP header
//	        connection.setRequestProperty("apikey",  "cfa39680f069cc1043c8ea824e737284");
	        connection.connect();
	        InputStream is = connection.getInputStream();
	        reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        String strRead = null;
	        while ((strRead = reader.readLine()) != null) {
	            sbf.append(strRead);
	            sbf.append("\r\n");
	        }
	        reader.close();
	        result = sbf.toString();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String httpUrl = "http://localhost:8080/cloud/spitter/porfile/3/rt";
		String httpArg = "citypinyin=beijing";
		String jsonResult = request(httpUrl, httpArg);
		JSONTokener jt = new JSONTokener(jsonResult);
		JSONObject jsonObj = (JSONObject)jt.nextValue();
		System.out.println(jsonResult);

	}

}
