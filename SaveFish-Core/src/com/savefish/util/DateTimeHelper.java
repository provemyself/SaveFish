package com.savefish.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeHelper {
	/**
	 * @description 获取当前系统日期时间
	 * @return
	 */
	public static String getDateTime() {
		String currentDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(Calendar.getInstance().getTime());
		return currentDateTime;
	}

	/**
	 * @description 获取当前系统日期
	 * @return
	 */
	public static String getDate() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar
				.getInstance().getTime());
		return currentDate;
	}
}
