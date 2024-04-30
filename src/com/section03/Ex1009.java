package com.section03;

public class Ex1009 {
	public static void main(String[] args) {
		int a = 100;
		int b = 200;
		Integer a2 = 100;
		Integer b2 = 200;
		
		System.out.println("a: " + a + "\tb: " + b + "\n");
		System.out.println("a2: " + a2 + "\tb2: " + b2 + "\n");
		
		String val1 = a2.toString();
		String val2 = Integer.toString(b2);
		
		System.out.println("a2.toString(): " + val1);
		System.out.println("Integer.toString(b2): " + val2);

	}

}
