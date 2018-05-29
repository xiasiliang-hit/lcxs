package com.lcxs.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {
	public static Long getId(){
		Date d=new Date();
		return d.getTime();
	}
	public static String getTime(){
		Date d=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(d);
	}
}
