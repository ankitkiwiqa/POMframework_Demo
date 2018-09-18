package com.demo.utility;

public class StringDemo {

	public static void main(String[] args) {
		
		String abc = "Inbox (1,215)";

		System.out.println(abc.replace("Inbox (", ""));
		
		abc = abc.replace("Inbox (", "");
		
		System.out.println(abc.replace(")", ""));
		
	}

}
