package com.zheng;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhenglian on 2017/5/5.
 */
public class CalendarBuilderTest {
	
	@Test
	public void testCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2017, 4, 1);
		Date date = calendar.getTime();
		System.out.println(date);
	}
	
	public static void main(String[] args) {
	    new CalendarBuilderTest().showCalendar();
	}
	
	public void showCalendar() {
		CalendarProduct calendarProduct = new ChineseCalendarBuilder(2017, 5).buildTitle().buildWeekTitle()
				.buildDayOfMonth().build();
		calendarProduct.show();
	}
}
