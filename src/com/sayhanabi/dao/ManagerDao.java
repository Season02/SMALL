package com.sayhanabi.dao;

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
	public int authenticationManager(String username, String password);
}
