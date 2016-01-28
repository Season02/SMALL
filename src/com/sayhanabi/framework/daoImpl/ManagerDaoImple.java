package com.sayhanabi.framework.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sayhanabi.common.db.MySQLIntrop;
import com.sayhanabi.framework.dao.ManagerDao;
import com.sayhanabi.framework.vo.Manager;

public class ManagerDaoImple implements ManagerDao 
{
	public static void main(String[] args)
	{
		ManagerDao dao = new ManagerDaoImple();
		System.out.println(dao.authentication("admin", "admin"));		
	}
	
	@Override
	public int authentication(String username, String password) 
	{
		int id = -1;
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

	@Override
	public int add(String username, String password) 
	{
		Map<String,Object> args = new HashMap<String,Object>();
		args.put(Manager.FIELDS[1], username);
		args.put(Manager.FIELDS[2], password);
		return MySQLIntrop.getMySQL().insert("tb_manager",args);
	}

	@Override
	public int getCounct() 
	{
		return MySQLIntrop.getMySQL().selectCount("tb_manager");
	}

	@Override
	public List<Manager> get() 
	{
		List<Manager> result = new ArrayList<>();
		List<HashMap<String,String>> list = MySQLIntrop.getMySQL().select("tb_manager",Manager.FIELDS);
		for(HashMap<String,String> map : list)
		{
			Manager manager = 
					new Manager(
							Integer.parseInt(map.get(Manager.FIELDS[0])), 
								map.get(Manager.FIELDS[1]), map.get(Manager.FIELDS[2]));
			result.add(manager);
		}
		return result;
	}

	@Override
	public List<Manager> get(int start, int length) 
	{
		List<Manager> result = new ArrayList<>();
		String[] limit = {String.valueOf(start),String.valueOf(length)};
		List<HashMap<String,String>> list = 
				MySQLIntrop.getMySQL().select("tb_manager",Manager.FIELDS,null,limit);
		for(HashMap<String,String> map : list)
		{
			Manager manager = 
					new Manager(
							Integer.parseInt(map.get(Manager.FIELDS[0])), 
								map.get(Manager.FIELDS[1]), map.get(Manager.FIELDS[2]));
			result.add(manager);
		}
		return result;
	}
	

}
