package com.section04;

import java.util.Calendar;
import java.util.Locale;
import static java.util.Calendar.*;
import java.util.Date;

public class Ex1011 {
	
	public static int getDiffYears(Date first, Date last) {
		Calendar a = getCalendar(first);
		Calendar b = getCalendar(last);
		int diff = b.get(YEAR) - a.get(YEAR);
		
		if (a.get(MONTH) > b.get(MONTH) ||
				(a.get(MONTH) == b.get(MONTH) &&
				a.get(DATE) > b.get(DATE))) {
			diff--;
		}
		return diff;
	}
	
	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance(Locale.KOREA);
		cal.setTime(date);
		return cal;
	}
	
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.print("현재 날짜 : ");
		System.out.print(cal.get(Calendar.YEAR) + "년");
		System.out.print((cal.get(Calendar.MONTH) + 1) + "월"); // 0부터 시작 
		System.out.print(cal.get(Calendar.DATE) + "일");
		
		Date my_bday = new Date(2000, 5, 27);
		Date today = new Date(2024, 4, 30);
		
		System.out.println();
		System.out.println("너의 나이는: " + getDiffYears(my_bday, today));
	}

}
