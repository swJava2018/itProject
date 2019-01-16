package com.sanan.demo.utils;

public class SananLogger {
	
	public static void debug(String txt) {
		System.out.println(txt);
	}
	
	public static void debug(String title, String txt) {
		System.out.println("[" + title + "] " + txt);
	}
	
}
