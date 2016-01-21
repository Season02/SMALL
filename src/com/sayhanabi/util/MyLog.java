package com.sayhanabi.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MyLog 
{	
	private static final String LOG_DIRECTORE_PATH = "d:\\";
	private static final String LOG_FILE_NAME = "JavaLog.txt";

	public static void buildLog(String str)
	{
	    try 
	    { 
            RandomAccessFile randomFile = new RandomAccessFile(LOG_DIRECTORE_PATH + LOG_FILE_NAME, "rw");
            long fileLength = randomFile.length();
            randomFile.seek(fileLength);  
            randomFile.write(( "[ " + MyDate.getDate() + " ] " + str + "\r\n").getBytes());
            //randomFile.writeBytes(str);  
            randomFile.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }	    
  
    }
	
	public static void parseLog()
	{
/*		File file = new File(LOG_DIRECTORE_PATH, LOG_FILE_NAME);
        try { 
            FileInputStream out = new FileInputStream(file);  
            InputStreamReader isr = new InputStreamReader(out);  
            int ch = 0;
            String line;
            
            while ((ch = isr.read()) != -1) {  
                System.out.print((char) ch);  
            }  
        } catch (Exception e) {  
            // TODO: handle exception  
        }*/
        
        StringBuffer sb= new StringBuffer("");
        FileReader reader;
        BufferedReader br;
        
        try
        {
        	reader = new FileReader(LOG_DIRECTORE_PATH + LOG_FILE_NAME);
        	br = new BufferedReader(reader);
        	
        	String str = null;
            
            while((str = br.readLine()) != null) {
                  sb.append(str+"/n");
                 
                  System.out.println(str);
            }
            
            br.close();
        	reader.close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }       
       
        
        
	}
	
}
