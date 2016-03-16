package com.sunway.ws;

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
		aaa("1");
	}

}
