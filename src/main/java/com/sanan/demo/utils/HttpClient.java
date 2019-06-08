package com.sanan.demo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.sanan.demo.exception.SananErrorCode;
import com.sanan.demo.exception.SananException;

public class HttpClient {
//	private String TAG = HttpClient.class.getName();
//	
//	public String send(String destUrl, String json, String auth) throws HttpException, SananException {
//		SananLogger.debug(TAG, "DEST URL: " + destUrl);
//		SananLogger.debug(TAG, "JSON: " + json);
//
//		String contentType = "application/x-www-form-urlencoded";
//		String charset = "UTF-8";
//		String method = "GET";
//		String url = destUrl;
//
//		InputStream is = null;
//		OutputStream writer = null;
//		HttpURLConnection connection = null;
//		String resultMsg = "";
//		int code = 0;
//		try {
//			URL urlO = new URL(url);
//			connection = (HttpURLConnection) urlO.openConnection();
//			
//			if (contentType != null) 
//				connection.setRequestProperty("Content-Type", contentType);			
//			if (auth != null)
//				connection.setRequestProperty("Authorization", auth);
//			
//			connection.setRequestProperty("Content-Length", String.valueOf(json.getBytes(charset).length));
//			connection.setDoInput(true);
//			connection.setDoOutput(true);
//			connection.setUseCaches(false);
//			connection.setDefaultUseCaches(false);
//			connection.setRequestMethod(method);
//			connection.setReadTimeout(60000);
//			connection.setConnectTimeout(10000);
//			connection.connect();
//			writer = connection.getOutputStream();
//			writer.write(json.getBytes(charset));
//			writer.flush();
//			writer.close();
//
//			code = connection.getResponseCode();
//			if (code < HttpURLConnection.HTTP_BAD_REQUEST) {
//				is = connection.getInputStream();
//			}
//			else {
//				is = connection.getErrorStream();
//			}
//
//			BufferedReader rd;
//			String line = null;
//			StringBuffer resp = new StringBuffer();
//			rd = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//			while ((line = rd.readLine()) != null) {
//				resp.append(line);
//			}
//			rd.close();
//			resultMsg = resp.toString();
//		}
//		catch (IOException e) {
//			throw new SananException(SananErrorCode.INTERNAL_ERROR, e);
//		}
//		
//		finally {
//			if (writer != null)
//				try {
//					writer.close();
//				}
//				catch (IOException e) {
//					throw new SananException(SananErrorCode.INTERNAL_ERROR, e);
//				}
//		}
//
//		if (code >= HttpURLConnection.HTTP_BAD_REQUEST) {
//			SananLogger.debug(TAG, "HTTP ERROR CODE: " + code);
//			SananLogger.debug(TAG, "HTTP RESULT MSG: " + resultMsg);
//			throw new HttpException(code, resultMsg, "http error");
//		}
//		SananLogger.debug(TAG, resultMsg);
//		return resultMsg;
//	}
}
