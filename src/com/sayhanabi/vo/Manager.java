package com.sayhanabi.vo;

public class Manager 
{
	private int id;
	private String manager;
	private String password;
	public static String FIELDS[] = { "id","manager","password" };
	
	public Manager(int id, String manager, String password)
	{
		this.id = id;
		this.manager = manager;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
