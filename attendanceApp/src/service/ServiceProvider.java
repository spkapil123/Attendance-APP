package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class ServiceProvider {
	
	public boolean loginValidation(String name,String password,String person){
		if(name!=null && !name.matches("")){
		Properties prop = new Properties();
		String path = "loginDetails.properties";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream input = loader.getResourceAsStream(path);
		
			try {
				prop.load(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String pass=prop.getProperty(name);
			System.out.println(pass.substring(0,8)+person+pass.substring(8));
			if(password.equals(pass.substring(0,8)) && person.equals(pass.substring(8))){
				return true;
			}else{
				return false;
			}
		}else return false;
		
	}
	
	public String setMonthlytableView(String userName,String value){
		Properties prop = new Properties();
		String entireRecord="";
		try {
			String path = "DateWiseAttendance.properties";
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream input = loader.getResourceAsStream(path);
			prop.load(input);
			String attendanceRecord=prop.getProperty(userName);
			String[] dateValues=value.split("/");
			if(dateValues.length>1){
				String[] individualRecords=attendanceRecord.split(",");
				for (String record : individualRecords) {
					if(record.substring(0, 10).equals(value)){
						entireRecord=record;
					}
				}
				//entireRecord=entireRecord.substring(0, entireRecord.length()-1);
			}else{
				String[] individualRecords=attendanceRecord.split(",");
				for (String record : individualRecords) {
					if(Integer.parseInt(record.substring(0, 2))==(Integer.parseInt(value))){
						entireRecord=record+","+entireRecord;
					}
				}
				entireRecord=entireRecord.substring(0, entireRecord.length()-1);
				//input.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return entireRecord;
	}
	
	
	public String getEmployees(){
		Properties prop = new Properties();
		String employees="";
		String path = "loginDetails.properties";
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream input = loader.getResourceAsStream(path);
		try {
			prop.load(input);
			Set<Object> values=prop.keySet();
			for (Object object : values) {
				String result=prop.getProperty((String) object);
				if(result.substring(8).equals("employee")){
					employees=object.toString()+","+employees;
				}
			}
			employees=employees.substring(0, employees.length()-1);
			//input.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
	
	public String getEmployeeAttandance(String name){
		if (name==null){
			return "";
		}
		Properties prop = new Properties();
		String entireRecord="";
		try {
			String path = "DateWiseAttendance.properties";
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream input = loader.getResourceAsStream(path);
			prop.load(input);
			entireRecord=prop.getProperty(name);
			//input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entireRecord;
	}	
}
