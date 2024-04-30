package com.section03;

//String 클래스 예시
public class Ex1006 {

	public static void main(String[] args) {
		String str1 = "www.naver.com";
		String[] arrStr1 = str1.split("\\.");
		
		for (int i= 0; i < arrStr1.length; i++)
			System.out.println(arrStr1[i]);

		String str2 = "Java";
		System.out.println(str2);
		System.out.println(str2.toUpperCase());
		System.out.println(str2.toUpperCase());
		
		for (int i = 0; i < str2.length(); i++)
			System.out.println(str2.charAt(i) + " . ");

		String str3 = str2.replace('a', 't');
		System.out.println("\n" + str3);
		
		String str4 = "I like to eat ice cream.";
		System.out.println(str4.substring(14).toUpperCase());
		System.out.println(str4.indexOf("dog"));
	}

}
