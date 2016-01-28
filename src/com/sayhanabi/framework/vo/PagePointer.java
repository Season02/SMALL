package com.sayhanabi.framework.vo;

/**
 * index and recode page information
 * @author sayhanabi
 *
 */
public class PagePointer 
{
	public int total = 0;   //count of all page
	public int current = 0; //current page index
	public int limit = 0;   //data count of one page
	
	/**
	 * @param total
	 * count of all page
	 * @param current
	 * current page index
	 * @param limit
	 * data count of one page
	 */
	public PagePointer(int total, int current, int limit)
	{
		this.total = total;
		this.current = current;
		this.limit = limit;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	
}
