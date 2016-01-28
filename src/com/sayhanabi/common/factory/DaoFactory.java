package com.sayhanabi.common.factory;

import com.sayhanabi.framework.dao.ManagerDao;
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
	
	public static ManagerDao getManager()
	{
		return manager;
	}	
}
