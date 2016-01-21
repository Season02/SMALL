package com.sayhanabi.util;

public class MyPrint {
	
	static public void ln()
	{
		System.out.println();
	}
	
/*	static public void ln(String str)
	{
		System.out.println("--> " + str);
	}*/
	
	static public <T> void ln(T str)
	{
		System.out.println("--> " + str);
	}

	static public void print(String str)
	{
		System.out.print(str);
	}
	
	static public void eln()
	{
		System.err.println();
	}
	
	static public void eln(String str)
	{
		System.err.println(str);
	}

}
