package com.zheng;

/**
 * 生成器接口
 * @author Administrator
 */
public interface CalendarBuilder {
	CalendarBuilder buildTitle();
	CalendarBuilder buildWeekTitle();
	CalendarBuilder buildDayOfMonth();
	CalendarProduct build();
}
