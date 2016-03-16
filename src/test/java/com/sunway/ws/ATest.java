package com.sunway.ws;

import java.util.HashMap;
import java.util.Map;

public class ATest {
	
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
		
		String aString = "123125哈哈";
		System.out.println(aString.length());
		
		
		Map<String, Object>  bb = new HashMap<String, Object>();
		
		System.out.println(bb.get("sdf"));
	}

}
