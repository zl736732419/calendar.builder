package com.zheng;

import java.util.Calendar;

public class ChineseCalendarBuilder implements CalendarBuilder {
	private CalendarProduct product;
	
	public ChineseCalendarBuilder(int year, int month) {
		product = new CalendarProduct(year, month);
		buildCalendar(year, month);
	}
	
	private void buildCalendar(int year, int month) {
		if(month >= 1 && month <= 12) {
			Calendar calendar = Calendar.getInstance();
			product.setCalendar(calendar);
			calendar.set(year, month-1, 1); //月份需要+1才是正确的月份
		}
	}
	
	@Override
	public CalendarBuilder buildTitle() {
		String title = product.getYear() + "年" + product.getMonth() + "月的日历牌";
		product.setTitle(title);
		return this;
	}

	@Override
	public CalendarBuilder buildWeekTitle() {
		String[] headers = {"日", "一","二","三","四","五","六"};
		product.setWeekTitle(headers);
		return this;
	}

	@Override
	public CalendarBuilder buildDayOfMonth() {
		//这里是重点，构造一月中的天数
		int isWeekDay = product.getCalendar().get(Calendar.DAY_OF_WEEK) - 1;//获取一月中的第一天对应星期几
		int day = getTotalMonthDay(product);//该月一共多少天
		
		int nextDay = 1;//月中天数从1开始算起
		String [][] dayOfMonth = initDayOfMonth();
		
		for(int k = 0; k < 6; k++) {
			if(k == 0) {//第一行，从这个月的第一天对应的星期开始算起
				for(int j = isWeekDay; j < 7; j++) {
					dayOfMonth[k][j] = "" + nextDay;
					nextDay++;
				}
			}else {
				for(int j = 0; j < 7 && nextDay <= day; j++) {
					dayOfMonth[k][j] = "" + nextDay;
					nextDay++;
				}
			}
		}
		product.setDayOfMonth(dayOfMonth);
		
		return this;
	}
	
	private String[][] initDayOfMonth() {
		String [][] dayOfMonth = new String[6][7];
		//初始化
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				dayOfMonth[i][j] = "";
			}
		}
		
		return dayOfMonth;
	}
	
	/**
	 * 获取当前月天数
	 * @param product
	 * @return
	 */
	private int getTotalMonthDay(CalendarProduct product) {
		int m = product.getMonth();
		int y = product.getYear();
		int day = 0;
		if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
			day = 31;
		}else if(m == 4 || m == 6 || m == 9 | m == 11) {
			day = 30;
		}else if(m == 2) { //闰年
			if(((y % 4 == 0) && (y % 100) != 0) //不能被100整除的年份能被4整除 
					|| (y % 400) == 0) { //能被100整除的年份必须被400整除
				day = 29;
			}else {
				day = 28;
			}
		}
		
		return day;
	}
	
	@Override
	public CalendarProduct build() {
		return product;
	}

}
