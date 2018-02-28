package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		Properties prop = new Properties();
		Properties prop1 = new Properties();
		OutputStream output = null;
		InputStream input = null;

		

			try {
				/*output = new FileOutputStream("loginDetails.properties");

				// set the properties value
				prop.setProperty("Ramesh", "12345678hr");
				prop.setProperty("Harish", "91011121hr");
				prop.setProperty("Soumya", "17181920employee");
				prop.setProperty("Deepak", "21222324employee");
				prop.setProperty("Girish", "13141516employee");
				prop.setProperty("Sirisha", "25262728employee");
				prop.setProperty("Bob", "29303132employee");
				prop.setProperty("Ganesh", "33343536employee");

				// save properties to project root folder
				prop.store(output, null);
				
				output = new FileOutputStream("DateWiseAttendance6.properties");
				String dt = "01/01/2017";  // Start date
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
				Calendar c = Calendar.getInstance();
				String x=sdf.format(c.getTime());
				String fullRecord="";
				int count=0;
				while(!dt.equals(x)){
				c.add(Calendar.DATE, -1);  // number of days to add
				x=sdf.format(c.getTime());
				System.out.println(x);
				count++;
				if(count%3==0){
				fullRecord=fullRecord+x+"-Absent"+",";
				}else if(count%2==0){
					fullRecord=fullRecord+x+"-Present"+",";
				}else{
					fullRecord=fullRecord+x+"-OfficialOut"+",";
				}
				}
				prop1.setProperty("Soumya", fullRecord);
				prop1.store(output, null);
*/				
				input = new FileInputStream("DateWiseAttendance1.properties");
				prop.load(input);
				input = new FileInputStream("DateWiseAttendance2.properties");
				prop.load(input);
				input = new FileInputStream("DateWiseAttendance3.properties");
				prop.load(input);
				input = new FileInputStream("DateWiseAttendance4.properties");
				prop.load(input);
				input = new FileInputStream("DateWiseAttendance5.properties");
				prop.load(input);
				input = new FileInputStream("DateWiseAttendance6.properties");
				prop.load(input);

				// get the property value and print it out
				//System.out.println(prop.getProperty("Deepak"));
				output = new FileOutputStream("DateWiseAttendance.properties");
				prop.store(output, null);
				

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
	}

}
