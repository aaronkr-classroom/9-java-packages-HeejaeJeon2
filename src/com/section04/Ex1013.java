package com.section04;

import java.util.Random;

public class Ex1013 {

	public static void main(String[] args) {
		Random r1 = new Random();
		System.out.println("난수 값: " + r1.nextInt());
		
		Random r2 = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.println(r2.nextInt(100));
		}

	}

}
