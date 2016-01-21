package com.sayhanabi.daoimple;

import java.util.HashMap;
import java.util.List;
import com.sayhanabi.dao.ManagerDao;
import com.sayhanabi.db.MySQLIntrop;
import com.sayhanabi.vo.Manager;

public class ManagerDaoImple implements ManagerDao 
{
	public static void main(String[] args)
	{
		ManagerDao dao = new ManagerDaoImple();
		System.out.println(dao.authenticationManager("admin", "admin"));		
	}
	
	@Override
	public int authenticationManager(String username, String password) 
	{
		int id = -1;
//		MySQLIntrop mysql = new MySQLIntrop();
//		mysql.connect();
		List<HashMap<String,String>> result = 
				MySQLIntrop.getMySQL().select("tb_manager",Manager.FIELDS);
		if(result != null)//LIST ARE UNORDERED!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		{
			for(HashMap<String,String> map : result)//check user
			{
				id = -1;
				//FIELDS[1] USERNAME,FIELDS[2] PASSWORD
				if(map.get(Manager.FIELDS[1]).equals(username) && map.get(Manager.FIELDS[2]).equals(password))
				{
					return Integer.parseInt(map.get(Manager.FIELDS[0]));
				}
			}
		}
		return -1;
	}
	

}
