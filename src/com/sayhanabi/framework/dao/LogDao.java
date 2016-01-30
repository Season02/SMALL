package com.sayhanabi.framework.dao;

public interface LogDao
{
	/**
	 * recode log
	 * @param recorder
	 * the people who added log
	 * @param Date
	 * the date log be added
	 * @param event
	 * log additional information
	 * @param Log
	 * log content
	 * @param request_ip
	 * remote ip
	 * @return
	 * recode condition(if failed return -1)
	 */
	public int addLog(String recorder, String event, String log, String request_ip);
}
