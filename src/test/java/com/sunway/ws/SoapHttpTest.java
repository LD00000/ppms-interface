package com.sunway.ws;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

@Rollback(true)
@ActiveProfiles("development")
public class SoapHttpTest {
	
	@Test
	public void test() {
		try {
			URL url = new URL("http://10.113.0.21:8001/erp/server/erp");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("POST");
	        conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
	        conn.setDoInput(true);
	        conn.setDoOutput(true);
	        
	        String xml = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
	        				+ "<soap:Body>"
	        		
	        				
	        				
	        				+ "</soap:Body>"
	        				+ "</soap:Envelope>";
	        
	        OutputStream os = conn.getOutputStream();
	        os.write(xml.getBytes());
	        
	        os.flush();
	        
	        InputStream is = conn.getInputStream();
	        byte[] bytes = new byte[xml.length()];
	        int length = 0;
	        while(is.read(bytes) != -1) {
	        	String string = new String(bytes, 0, length, "UTF-8");
	        	System.out.println(string);
	        }
	        
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
