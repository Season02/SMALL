package com.sayhanabi.framework.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Log
{
	private String recorder;
	private String date;
	private String event;
	private String log;
	private String remote_ip;
	public static String TABLE = "tb_log";
	public static String FIELDS[] = { "recorder","date","event","log","remote_ip" };
	
	public Log(String recorder, String date, String event, String log, String remote_ip)
	{
		this.recorder = recorder;
		this.date = date;
		this.event = event;
		this.log = log;
		this.remote_ip = remote_ip;
	}
	
	public Log(String recorder, String event, String log , String remote_ip)
	{
		this.recorder = recorder;
		try
		{
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			this.date = sdf.format(d);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		this.event = event;
		this.log = log;
		this.remote_ip = remote_ip;
	}


	public String getEvent()
	{
		return event;
	}

	public void setEvent(String event)
	{
		this.event = event;
	}

	public String getRemote_ip()
	{
		return remote_ip;
	}

	public void setRemote_ip(String remote_ip)
	{
		this.remote_ip = remote_ip;
	}

	public String getRecorder()
	{
		return recorder;
	}

	public void setUser(String recorder)
	{
		this.recorder = recorder;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}

	public String getLog()
	{
		return log;
	}

	public void setLog(String log)
	{
		this.log = log;
	}

	public static String[] getFIELDS()
	{
		return FIELDS;
	}

	public static void setFIELDS(String[] fIELDS)
	{
		FIELDS = fIELDS;
	}
	
}
