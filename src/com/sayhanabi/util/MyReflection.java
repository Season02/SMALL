package com.sayhanabi.util;

import java.lang.reflect.Method;

public class MyReflection {
	
	public static <T> Method getNoArgueMethod(T object, String name)
	{
		Method method;
		try
		{
			Class obj = object.getClass();
			method = obj.getDeclaredMethod(name, null);
		}
		catch(Exception e)
		{
			MyLog.buildLog(e.getMessage());
			return null;
		}
		return method;		
	}
	
	/*
	public static <T> Method getSetterByFieldName(T object, String field)
	{
		try
		{
			Class obj = object.getClass();
	        Method setter = obj.getDeclaredMethod(CaseHelper.setMe(field), String.class);
	        setter.invoke(object,entry.getValue());
	        stus.add(stu);
		}
		catch(Exception e)
		{
			
		}		
	}*/
	
	public static <T,P> P invokeGetterByFieldName(T object, String name)
	{
		try
		{
			Class obj = object.getClass();
	        Method getter = obj.getDeclaredMethod(CaseHelper.getMe(name), null);
	        P result = (P)getter.invoke(object,null);
	        return result;
		}
		catch(Exception e)
		{
			MyLog.buildLog(e.getMessage());
			return null;
			//e.printStackTrace();
		}		
	}
	
	public static <T> void invokeSetterByFieldName(T object, String field, String value)
	{
		try
		{
			Class obj = object.getClass();
	        Method setter = obj.getDeclaredMethod(CaseHelper.setMe(field), String.class);
	        setter.invoke(object,value);
		}
		catch(Exception e)
		{
			MyLog.buildLog(e.getMessage());
		}		
	}

}
