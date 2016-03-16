package com.sunway.ws.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class RestClient {
	
	public static void main(String[] args) {
		try {
			doPost("http://10.113.0.21:8001/erp/erp/cght", "sdaf", "UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * post方式发送请求
	 * 
	 * @param postUrl 请求的地址
	 * @param postXml xml字符串参数
	 * @param postCode 字符编码格式
	 * @return
	 * @throws Exception 
	 */
	public static String doPost(String postUrl, String postStr, String postCode) throws Exception {
		URL url = new URL(postUrl);
		URLConnection urlConnection = url.openConnection();
		HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
		
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setRequestProperty("Accept-Charset", postCode);
		httpURLConnection.setRequestProperty("Content-Type", "text/json");
		
		OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;
        
        try {
        	outputStream = httpURLConnection.getOutputStream();
        	outputStreamWriter = new OutputStreamWriter(outputStream, postCode);
        	
        	outputStreamWriter.write(postStr);
        	outputStreamWriter.flush();
        	
        	if (httpURLConnection.getResponseCode() >= 300) {
        		throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
        	}
        	
        	inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);
            
            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }
            
        } finally {
        	if (outputStreamWriter != null) 
                outputStreamWriter.close();
            
            if (outputStream != null) 
                outputStream.close();
            
            if (reader != null) 
                reader.close();
            
            if (inputStreamReader != null) 
                inputStreamReader.close();
            
            if (inputStream != null) 
                inputStream.close();
        }
		return resultBuffer.toString();
	}
	
}
