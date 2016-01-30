package com.sayhanabi.framework.daoImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sayhanabi.common.db.MySQLIntrop;
import com.sayhanabi.framework.dao.LogDao;
import com.sayhanabi.framework.vo.Log;

public class LogDaoImple implements LogDao
{

	@Override
	public int addLog(String recorder, String event, String log, String remote_ip)
	{
		Map<String,Object> args = new HashMap<String,Object>();
		args.put(Log.FIELDS[0], recorder);
		args.put(Log.FIELDS[2], event);
		args.put(Log.FIELDS[3], log);
		args.put(Log.FIELDS[4], remote_ip);
		try
		{
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			args.put(Log.FIELDS[1], sdf.format(d));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return MySQLIntrop.getMySQL().insert(Log.TABLE,args);
	}

}
