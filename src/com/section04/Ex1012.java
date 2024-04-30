package com.section04;

import java.util.StringTokenizer;

public class Ex1012 {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("Java, C, Python, JSP, PHP", ",");
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}

	}

}
