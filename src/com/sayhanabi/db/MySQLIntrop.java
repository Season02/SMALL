package com.sayhanabi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MySQLIntrop
{
	private Connection connection;
	private final String CLASSPATCH = "com.mysql.jdbc.Driver";
	private final String ACCOUNT = "root";
	private final String PASSWORD = "admin";
	private final String URL = "jdbc:mysql://localhost:3306/small";
	private final String MYSQL_BASIC_URL = "jdbc:mysql://localhost:3306/"; 
	
	private static MySQLIntrop instance = new MySQLIntrop();
	
	/**
	 * get a public instance insure just a object in context
	 * @return current instance
	 */
	public static MySQLIntrop getMySQL()
	{
		if(instance.connection == null)
			instance.connect();
		return instance;
	}
	
	private MySQLIntrop()
	{
	}
	
	public static void main(String[] args)
	{
//		Map<String,Object> map = new HashMap<String,Object>();
//		//map.put("id", 190);
//		map.put("age", 66);
//		map.put("sex", "男");
//		map.put("department", "科学");

		MySQLIntrop dbc = new MySQLIntrop();
		dbc.connect();
//		dbc.alter("test", "code");
//		System.out.println(dbc.disconnect());
		String[] arg = {"id","manager","password"};
		List<HashMap<String,String>> list = dbc.select("tb_manager",arg);
		for(HashMap<String,String> map : list)
		{
			for(Map.Entry<String, String> entry : map.entrySet())
			{
				System.out.print(entry.getKey() + "  " + entry.getValue() + "  ");
			}
			System.out.print("");
		}
		
		//if(dbc.connect())
			//System.out.println(dbc.delete("student",10));
//			System.out.println(dbc.update("student",map,1));
//			System.out.println(dbc.insert("student",map));
			//System.out.println(dbc.insert("student",par,arg));
		//dbc.disconnect();
	}
	
	public boolean connect()
	{
		try
		{
		    Class.forName(CLASSPATCH);
		    connection = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
		    return true;
		}
		catch(ClassNotFoundException e)
		{   
		    System.err.println("Can`t find driver class!");   
		    e.printStackTrace();
		    return false;
		} 
		catch(SQLException ee)
		{
			System.err.println("Can`t get connection!");   
		    ee.printStackTrace();
		    return false;
		}
	}
	
	public Connection getConnection()
	{
		return connection;
	}
	
	public ResultSet select(String str)
	{
		ResultSet rs;
		Statement st;
		if(connection != null)
		{
			try 
			{
				st = connection.createStatement();
				rs = st.executeQuery("select * from " + str);
				
				return rs;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				return null;
			}

		}
		throw new NullPointerException();
		//return null;
	}
	
	/**
	 * This method will take a map who has initialized key as a parameter,the 
	 * key of this map is the table head,and the map`s value are all null,when
	 * this method executed the value will be set. 
	 * @param table
	 * table name
	 * @param value
	 * key parameter name value values
	 * @return
	 * if operation success return true,else return false
	 */
	public List<HashMap<String,String>> select(String table,String[] arguments)
	{
		ResultSet rs;
		Statement st;
		List<HashMap<String,String>> result = new ArrayList<>(); 
		if(connection != null)
		{
			try 
			{
				st = connection.createStatement();
				rs = st.executeQuery("select * from " + table);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				return null;
			}
		}
		else
		{
			return null;
		}
		try 
		{
			while(rs.next())
			{
				HashMap<String,String> map = new HashMap<>();
				for(String par:arguments)
				{
					map.put(par,rs.getString(par));
				}
				result.add(map);
			}
			return result;
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @param table
	 * table name
	 * @param arge
	 * key parameters value argument
	 * @return
	 * count of executed commands
	 */
	public int insert(String table,Map<String,Object> args)
	{
		if(table!=null && args!=null && args.size()>0)
		{
			List<String> parameters = new ArrayList<>();
			String[] pars;
			List arguments = new ArrayList();		
	         	
	    	for (Map.Entry<String, Object> entry : args.entrySet())
	    	{
	    		parameters.add(entry.getKey());
	    		arguments.add(entry.getValue());
	    	}
	    	
	    	pars = new String[parameters.size()];
	    	for(int i = 0;i<parameters.size();i++)
	    	{
	    		pars[i] = parameters.get(i);
	    	}
	    	
	    	return insert(table,pars,arguments);
		}
		else
		{
			return -1;
		}	
	}
	
	/**
	 * 
	 * @param table
	 * table name
	 * @param arge
	 * key parameters value argument
	 * @return
	 * count of executed commands
	 */
	public int update(String table,Map<String,Object> args, int id)
	{
		if(table!=null && args!=null && args.size()>0)
		{
			StringBuffer sql = null;
			List<String> parameters = new ArrayList();
			String[] pars;
			List arguments = new ArrayList();		
	         	
	    	for (Map.Entry<String, Object> entry : args.entrySet())
	    	{
	    		parameters.add(entry.getKey());
	    		arguments.add(entry.getValue());
	    	}
	    	
	    	pars = new String[parameters.size()];
	    	for(int i = 0;i<parameters.size();i++)
	    	{
	    		pars[i] = parameters.get(i);
	    	}
	    	
	    	return update(table,pars,arguments,id);
		}
		else
		{
			return -1;
		}	
	}
	
	/**
	 * 
	 * @param table
	 * table name
	 * @param parameters
	 * arguments name
	 * @param arguments
	 * to be inserted arguments
	 * @return
	 * count of executed commands
	 */ 
	int delete(String table, int id)
	{
		StringBuffer sql = null;
		sql = new StringBuffer( "delete from " + table + " where id = " + "'" + id + "'");

		if(connection != null)
		{
			int result = -1;
			try
			{
				PreparedStatement pstmt = connection.prepareStatement(sql.toString());				
				result = pstmt.executeUpdate();
				pstmt.close();
				return result;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return -1;
			}
		}
		else
		{
			return -1;
		}
	}
		
	/**
	 * 
	 * @param table
	 * table name
	 * @param parameters
	 * arguments name
	 * @param arguments
	 * to be inserted arguments
	 * @return
	 * count of executed commands
	 */ 
	int update(String table,String[] parameters, @SuppressWarnings("rawtypes") List arguments, int id)
	{
		StringBuffer sql = null;
		if(arguments != null && parameters.length == arguments.size())
		{
			sql = new StringBuffer( "update " + table + " set " );
			for(int i = 0;i<parameters.length;i++)
			{
				if(i<parameters.length - 1)
				{
					sql.append(parameters[i] + " = '");
					sql.append(arguments.get(i) + "', ");
				}
				else
				{
					sql.append(parameters[i] + " = '");
					sql.append(arguments.get(i) + "' ");
				}
			}
			sql.append("where id = " + id);			
		}
		else
		{
			return -1;
		}
		if(connection != null)
		{
			int result = -1;
			try
			{
				PreparedStatement pstmt = connection.prepareStatement(sql.toString());				
				result = pstmt.executeUpdate(sql.toString());
				pstmt.close();
				return result;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return -1;
			}
		}
		else
		{
			return -1;
		}
	}
	
	/**
	 * Add a new column
	 * @param table
	 * table name
	 * @param columnName
	 * column name
	 * @param columnName
	 * column type
	 * @return
	 * count of executed commands
	 */ 
	int alter(String table, String columnName, String columnType, String defaultValue)
	{
		StringBuffer sql = new StringBuffer( "alter table " + table + " add column " + columnName + " " + columnType + " default " + defaultValue );
		if(connection != null)
		{
			int result = -1;
			try
			{
				PreparedStatement pstmt = connection.prepareStatement(sql.toString());				
				result = pstmt.executeUpdate(sql.toString());
				pstmt.close();
				return result;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return -1;
			}
		}
		else
		{
			return -1;
		}
	}
	
	/**
	 * delete a column
	 * @param table
	 * table name
	 * @param columnName
	 * column name
	 * @return
	 * count of executed commands
	 */ 
	int alter(String table, String columnName)
	{
		StringBuffer sql = new StringBuffer( "alter table " + table + " drop column " + columnName );
		if(connection != null)
		{
			int result = -1;
			try
			{
				PreparedStatement pstmt = connection.prepareStatement(sql.toString());				
				result = pstmt.executeUpdate(sql.toString());
				pstmt.close();
				return result;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return -1;
			}
		}
		else
		{
			return -1;
		}
	}
	
	/**
	 * 
	 * @param table
	 * table name
	 * @param parameters
	 * arguments name
	 * @param arguments
	 * to be inserted arguments
	 * @return
	 * count of executed commands
	 */
	/**
	 * @param table
	 * @param parameters
	 * @param arguments
	 * @return
	 */
	public int insert(String table,String[] parameters, @SuppressWarnings("rawtypes") List arguments)
	{
		StringBuffer sql = null;
		if(arguments != null && parameters.length == arguments.size())
		{
			sql = new StringBuffer( "insert into " + table + " (" );
			for(int i = 0;i<parameters.length;i++)
			{
				if(i<parameters.length - 1)
				{
					sql.append(parameters[i] + ",");
				}
				else
				{
					sql.append(parameters[i]);
				}
			}
			sql.append(") values(");
//			for(int i = 0;i<parameters.length;i++)
//			{
//				if(i<parameters.length - 1)
//				{
//					sql.append("?,");
//				}
//				else
//				{
//					sql.append("?");
//				}
//			}
			for(int i = 0;i<parameters.length;i++)
			{
				if(i<parameters.length - 1)
				{
					sql.append("'" + arguments.get(i) + "',");
				}
				else
				{
					sql.append("'" + arguments.get(i) + "'");
				}
			}
			sql.append(")");				
		}
		else
		{
			return -1;
		}
		if(connection != null)
		{
			int result = -1;
			try
			{
				PreparedStatement pstmt = connection.prepareStatement(sql.toString());				
//				for(int i=0;i<parameters.length;i++)
//				{
//					String type[] = arguments.get(i).getClass().toString().split("\\.");
//					System.out.println(type[type.length - 1] + i + arguments.get(i).toString());					
//					switch(type[type.length - 1])
//					{
//						case "String":
//							pstmt.setString(i + 1, (String)arguments.get(i));
//							break;
//						case "Integer":
//							pstmt.setInt(i + 1, (Integer)arguments.get(i));
//							break;
//						default:
//							break;
//					}
//				}
				result = pstmt.executeUpdate(sql.toString());
				pstmt.close();
				return result;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				return -1;
			}
		}
		else
		{
			return -1;
		}
	}
	
	public boolean disconnect()
	{
		if(connection != null)
		{
			try 
			{
				connection.close();
				connection = null;
				return true;
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}
	
	
	
}



