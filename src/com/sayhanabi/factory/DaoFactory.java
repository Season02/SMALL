package com.sayhanabi.factory;

import com.sayhanabi.dao.ManagerDao;
import com.sayhanabi.daoimple.ManagerDaoImple;

/**
 * Implemented dao class all here
 * Add all singleton model
 * @author sayhanabi
 *
 */
public class DaoFactory 
{
	public static ManagerDao manager = new ManagerDaoImple();
	
	public static ManagerDao getManager()
	{
		return manager;
	}
	
}
