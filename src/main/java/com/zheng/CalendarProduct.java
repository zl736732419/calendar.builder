package com.zheng;

import javax.swing.*;
import java.util.Calendar;

/**
 * 含有多个组件的复杂产品对象
 * @author Administrator
 */
public class CalendarProduct {
	private String title;
	private String[] weekTitle;
	private String[][] dayOfMonth;//6行7列的数组
	private Calendar calendar;
	private int year = 2017;
	private int month = 5;
	public CalendarProduct(int year, int month) {
		this.year = year;
		this.month = month;
	}
	
	public void show() {
		JTable table = new JTable(dayOfMonth, weekTitle);
		JDialog dialog = new JDialog();
		dialog.setTitle(title);
		dialog.add(new JScrollPane(table));
		dialog.setBounds(130, 160, 220, 180);
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String[] getWeekTitle() {
		return weekTitle;
	}
	
	public void setWeekTitle(String[] weekTitle) {
		this.weekTitle = weekTitle;
	}
	
	public String[][] getDayOfMonth() {
		return dayOfMonth;
	}
	
	public void setDayOfMonth(String[][] dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}
	
	public Calendar getCalendar() {
		return calendar;
	}
	
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
}
