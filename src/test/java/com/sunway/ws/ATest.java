package com.sunway.ws;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ATest {
	
	private static final Gson gson = new GsonBuilder().serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	
	public class Tt {
		private String aString;

		public String getaString() {
			return aString;
		}

		public void setaString(String aString) {
			this.aString = aString;
		}
	}
	
	public static void aaa(String... strings) {
		System.out.println(strings.length);
		System.out.println(strings == null);
		for (String string : strings) {
			System.out.println(string);
		}
		System.out.println(strings[1]);
	}
	
	public static void main(String[] args) {
//		aaa("1");
		
//		String aString = "123125哈哈";
//		System.out.println(aString.length());
//		
//		
//		Map<String, Object>  bb = new HashMap<String, Object>();
//		
//		System.out.println(bb.get("sdf"));
		
		ATest aTest = new ATest();
		Tt tt = aTest.new Tt();
		
		String json = null;
		
		System.out.println(gson.fromJson(json, Tt.class));
		
	}

}
