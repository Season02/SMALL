package com.sayhanabi.util;

public class CaseHelper {
	
	public static void main(String[] args)
	{
		MyPrint.ln(setMe("phone"));
	}
	
	public static String firstUp(String str)
	{
		try
		{
			return str.toUpperCase().substring(0,1)
					+ str.toLowerCase().substring(1,str.length());
		}
		catch(Exception e)
		{
			MyLog.buildLog(e.getMessage());
			return null;
		}		
	}
	
	public static String getMe(String me)
	{
		try
		{
			return "get" + me.toUpperCase().substring(0,1)
					+ me.toLowerCase().substring(1,me.length());//ME!ME!ME!3ME!
		}
		catch(Exception e)
		{
			MyLog.buildLog(e.getMessage());
			return null;
		}		
	}
	
	//At present,can`t handle with the "have second caption word" like "registerDate".
	public static String setMe(String me)
	{
		try
		{
			return "set" + me.toUpperCase().substring(0,1)
					+ me.toLowerCase().substring(1,me.length());//ME!ME!ME!3ME!
		}
		catch(Exception e)
		{
			MyLog.buildLog(e.getMessage());
			return null;
		}		
	}

}
