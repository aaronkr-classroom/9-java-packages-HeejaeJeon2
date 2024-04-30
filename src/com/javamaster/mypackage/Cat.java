package com.javamaster.mypackage;

public class Cat {
	String breed;
	String color;
	
	public String eat() {
		String result = "먹이를 먹다";
		System.out.println(result);
		return result;
	}
	
	public String scratch() {
		String result = "발톱으로 할퀴다";
		System.out.println(result);
		return result;
	}
	
	public String meow() {
		String result = "야옹하고 울다";
		System.out.println(result);
		return result;
	}
}
