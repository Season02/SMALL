package com.sayhanabi.framework.dao;

import java.util.List;

import com.sayhanabi.framework.vo.Manager;

/**
 * Method all here are deal with td_manager 
 * @author Sayhanabi
 *
 */
public interface ManagerDao 
{
	/**
	 * Do Administrator login check
	 * @param username
	 * @param password
	 * @return
	 * if check failure will return -1 else will return the id
	 */
	public int authentication(String username, String password);
	/**
	 * Add Administrator if failed will return -1
	 * @param username
	 * @param password
	 * @return
	 */
	public int add(String username, String password);
	/**
	 * @return
	 * Manager count if filed return -1
	 */
	public int getCounct();
	/**
	 * get all manager from database
	 * @return
	 */
	public List<Manager> get();
	/**
	 * get result separated by start and end 
	 * @param start
	 * start index
	 * @param length
	 * count of data
	 * @return
	 * result
	 */
	public List<Manager> get(int start, int length);


}
