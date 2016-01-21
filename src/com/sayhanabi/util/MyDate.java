package com.sayhanabi.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDate {
	
	public enum WEEK
	{
		SUN,MON,THU,TUR,TWU,FAR,SAT
	}
	
	static public String[] week = 
			new String[]{"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY"};
	
	static public String getDate()
	{
		try
		{
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// public final String format(Date date)
			String s = sdf.format(d);
			return s;
			
		}catch(Exception e){
			return null;
		}
	}
	
	static public String getCurrentWeek()
	{
		try
		{
			Calendar calendar = Calendar.getInstance();
			return week[calendar.get(Calendar.DAY_OF_WEEK)];
		}catch(Exception e){
			return null;
		}  
	}
	
	static public String getDaytoSun()
	{
		try
		{
			Calendar calendar = Calendar.getInstance();
			return String.valueOf( 8 - calendar.get(Calendar.DAY_OF_WEEK) );
			
		}catch(Exception e){
			return null;
		}  
	}
	
	static public void getDay()
	{
		try
		{
			
		}catch(Exception e){
			//return null;
		}  
	}
	

}
