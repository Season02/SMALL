package com.sayhanabi.common.factory;

import com.sayhanabi.framework.dao.LogDao;
import com.sayhanabi.framework.dao.ManagerDao;
import com.sayhanabi.framework.daoImpl.LogDaoImple;
import com.sayhanabi.framework.daoImpl.ManagerDaoImple;

/**
 * Implemented dao class all here
 * Add all singleton model
 * @author sayhanabi
 *
 */
public class DaoFactory 
{
	public static ManagerDao manager = new ManagerDaoImple();
	public static LogDao log = new LogDaoImple();
	
	public static ManagerDao getManager()
	{
		return manager;
	}
	
	public static LogDao getLog()
	{
		return log;
	}
}

