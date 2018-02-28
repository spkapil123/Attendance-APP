package appServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ServiceProvider;

/**
 * Servlet implementation class HrHome
 */
@WebServlet("/HrHome")
public class HrHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession();
		
		String empName=request.getParameter("name");
		httpSession.setAttribute("employeeName", empName);
		ServiceProvider provider=new ServiceProvider();
		String attendanceRecord=provider.getEmployeeAttandance(empName);
	//	String attendanceRecord="02/27/2018-Absent,02/26/2018-Present,02/25/2018-Absent,02/24/2018-Present,02/23/2018-Absent,02/22/2018-Present,02/21/2018-Absent,02/20/2018-Present,02/19/2018-Absent,02/18/2018-Present,02/17/2018-Absent,02/16/2018-Present,02/15/2018-Absent,02/14/2018-Present,02/13/2018-Absent,02/12/2018-Present,02/11/2018-Absent,02/10/2018-Present,02/09/2018-Absent,02/08/2018-Present,02/07/2018-Absent,02/06/2018-Present,02/05/2018-Absent,02/04/2018-Present,02/03/2018-Absent,02/02/2018-Present,02/01/2018-Absent,01/31/2018-Present,01/30/2018-Absent,01/29/2018-Present,01/28/2018-Absent,01/27/2018-Present,01/26/2018-Absent,01/25/2018-Present,01/24/2018-Absent,01/23/2018-Present,01/22/2018-Absent,01/21/2018-Present,01/20/2018-Absent,01/19/2018-Present,01/18/2018-Absent,01/17/2018-Present,01/16/2018-Absent,01/15/2018-Present,01/14/2018-Absent,01/13/2018-Present,01/12/2018-Absent,01/11/2018-Present,01/10/2018-Absent,01/09/2018-Present,01/08/2018-Absent,01/07/2018-Present,01/06/2018-Absent,01/05/2018-Present,01/04/2018-Absent,01/03/2018-Present,01/02/2018-Absent,01/01/2018-Present,12/31/2018-Absent,12/30/2017-Present,12/29/2017-Absent,12/28/2017-Present,12/27/2017-Absent,12/26/2017-Present,12/25/2017-Absent,12/24/2017-Present,12/23/2017-Absent,12/22/2017-Present,12/21/2017-Absent,12/20/2017-Present,12/19/2017-Absent,12/18/2017-Present,12/17/2017-Absent,12/16/2017-Present,12/15/2017-Absent,12/14/2017-Present,12/13/2017-Absent,12/12/2017-Present,12/11/2017-Absent,12/10/2017-Present,12/09/2017-Absent,12/08/2017-Present,12/07/2017-Absent,12/06/2017-Present,12/05/2017-Absent,12/04/2017-Present,12/03/2017-Absent,12/02/2017-Present,12/01/2017-Absent,11/30/2017-Present,11/29/2017-Absent,11/28/2017-Present,11/27/2017-Absent,11/26/2017-Present,11/25/2017-Absent,11/24/2017-Present,11/23/2017-Absent,11/22/2017-Present,11/21/2017-Absent,11/20/2017-Present,11/19/2017-Absent,11/18/2017-Present,11/17/2017-Absent,11/16/2017-Present,11/15/2017-Absent,11/14/2017-Present,11/13/2017-Absent,11/12/2017-Present,11/11/2017-Absent,11/10/2017-Present,11/09/2017-Absent,11/08/2017-Present,11/07/2017-Absent,11/06/2017-Present,11/05/2017-Absent,11/04/2017-Present,11/03/2017-Absent,11/02/2017-Present,11/01/2017-Absent,10/31/2017-Present,10/30/2017-Absent,10/29/2017-Present,10/28/2017-Absent,10/27/2017-Present,10/26/2017-Absent,10/25/2017-Present,10/24/2017-Absent,10/23/2017-Present,10/22/2017-Absent,10/21/2017-Present,10/20/2017-Absent,10/19/2017-Present,10/18/2017-Absent,10/17/2017-Present,10/16/2017-Absent,10/15/2017-Present,10/14/2017-Absent,10/13/2017-Present,10/12/2017-Absent,10/11/2017-Present,10/10/2017-Absent,10/09/2017-Present,10/08/2017-Absent,10/07/2017-Present,10/06/2017-Absent,10/05/2017-Present,10/04/2017-Absent,10/03/2017-Present,10/02/2017-Absent,10/01/2017-Present,09/30/2017-Absent,09/29/2017-Present,09/28/2017-Absent,09/27/2017-Present,09/26/2017-Absent,09/25/2017-Present,09/24/2017-Absent,09/23/2017-Present,09/22/2017-Absent,09/21/2017-Present,09/20/2017-Absent,09/19/2017-Present,09/18/2017-Absent,09/17/2017-Present,09/16/2017-Absent,09/15/2017-Present,09/14/2017-Absent,09/13/2017-Present,09/12/2017-Absent,09/11/2017-Present,09/10/2017-Absent,09/09/2017-Present,09/08/2017-Absent,09/07/2017-Present,09/06/2017-Absent,09/05/2017-Present,09/04/2017-Absent,09/03/2017-Present,09/02/2017-Absent,09/01/2017-Present,08/31/2017-Absent,08/30/2017-Present,08/29/2017-Absent,08/28/2017-Present,08/27/2017-Absent,08/26/2017-Present,08/25/2017-Absent,08/24/2017-Present,08/23/2017-Absent,08/22/2017-Present,08/21/2017-Absent,08/20/2017-Present,08/19/2017-Absent,08/18/2017-Present,08/17/2017-Absent,08/16/2017-Present,08/15/2017-Absent,08/14/2017-Present,08/13/2017-Absent,08/12/2017-Present,08/11/2017-Absent,08/10/2017-Present,08/09/2017-Absent,08/08/2017-Present,08/07/2017-Absent,08/06/2017-Present,08/05/2017-Absent,08/04/2017-Present,08/03/2017-Absent,08/02/2017-Present,08/01/2017-Absent,07/31/2017-Present,07/30/2017-Absent,07/29/2017-Present,07/28/2017-Absent,07/27/2017-Present,07/26/2017-Absent,07/25/2017-Present,07/24/2017-Absent,07/23/2017-Present,07/22/2017-Absent,07/21/2017-Present,07/20/2017-Absent,07/19/2017-Present,07/18/2017-Absent,07/17/2017-Present,07/16/2017-Absent,07/15/2017-Present,07/14/2017-Absent,07/13/2017-Present,07/12/2017-Absent,07/11/2017-Present,07/10/2017-Absent,07/09/2017-Present,07/08/2017-Absent,07/07/2017-Present,07/06/2017-Absent,07/05/2017-Present,07/04/2017-Absent,07/03/2017-Present,07/02/2017-Absent,07/01/2017-Present,06/30/2017-Absent,06/29/2017-Present,06/28/2017-Absent,06/27/2017-Present,06/26/2017-Absent,06/25/2017-Present,06/24/2017-Absent,06/23/2017-Present,06/22/2017-Absent,06/21/2017-Present,06/20/2017-Absent,06/19/2017-Present,06/18/2017-Absent,06/17/2017-Present,06/16/2017-Absent,06/15/2017-Present,06/14/2017-Absent,06/13/2017-Present,06/12/2017-Absent,06/11/2017-Present,06/10/2017-Absent,06/09/2017-Present,06/08/2017-Absent,06/07/2017-Present,06/06/2017-Absent,06/05/2017-Present,06/04/2017-Absent,06/03/2017-Present,06/02/2017-Absent,06/01/2017-Present,05/31/2017-Absent,05/30/2017-Present,05/29/2017-Absent,05/28/2017-Present,05/27/2017-Absent,05/26/2017-Present,05/25/2017-Absent,05/24/2017-Present,05/23/2017-Absent,05/22/2017-Present,05/21/2017-Absent,05/20/2017-Present,05/19/2017-Absent,05/18/2017-Present,05/17/2017-Absent,05/16/2017-Present,05/15/2017-Absent,05/14/2017-Present,05/13/2017-Absent,05/12/2017-Present,05/11/2017-Absent,05/10/2017-Present,05/09/2017-Absent,05/08/2017-Present,05/07/2017-Absent,05/06/2017-Present,05/05/2017-Absent,05/04/2017-Present,05/03/2017-Absent,05/02/2017-Present,05/01/2017-Absent,04/30/2017-Present,04/29/2017-Absent,04/28/2017-Present,04/27/2017-Absent,04/26/2017-Present,04/25/2017-Absent,04/24/2017-Present,04/23/2017-Absent,04/22/2017-Present,04/21/2017-Absent,04/20/2017-Present,04/19/2017-Absent,04/18/2017-Present,04/17/2017-Absent,04/16/2017-Present,04/15/2017-Absent,04/14/2017-Present,04/13/2017-Absent,04/12/2017-Present,04/11/2017-Absent,04/10/2017-Present,04/09/2017-Absent,04/08/2017-Present,04/07/2017-Absent,04/06/2017-Present,04/05/2017-Absent,04/04/2017-Present,04/03/2017-Absent,04/02/2017-Present,04/01/2017-Absent,03/31/2017-Present,03/30/2017-Absent,03/29/2017-Present,03/28/2017-Absent,03/27/2017-Present,03/26/2017-Absent,03/25/2017-Present,03/24/2017-Absent,03/23/2017-Present,03/22/2017-Absent,03/21/2017-Present,03/20/2017-Absent,03/19/2017-Present,03/18/2017-Absent,03/17/2017-Present,03/16/2017-Absent,03/15/2017-Present,03/14/2017-Absent,03/13/2017-Present,03/12/2017-Absent,03/11/2017-Present,03/10/2017-Absent,03/09/2017-Present,03/08/2017-Absent,03/07/2017-Present,03/06/2017-Absent,03/05/2017-Present,03/04/2017-Absent,03/03/2017-Present,03/02/2017-Absent,03/01/2017-Present,02/28/2017-Absent,02/27/2017-Present,02/26/2017-Absent,02/25/2017-Present,02/24/2017-Absent,02/23/2017-Present,02/22/2017-Absent,02/21/2017-Present,02/20/2017-Absent,02/19/2017-Present,02/18/2017-Absent,02/17/2017-Present,02/16/2017-Absent,02/15/2017-Present,02/14/2017-Absent,02/13/2017-Present,02/12/2017-Absent,02/11/2017-Present,02/10/2017-Absent,02/09/2017-Present,02/08/2017-Absent,02/07/2017-Present,02/06/2017-Absent,02/05/2017-Present,02/04/2017-Absent,02/03/2017-Present,02/02/2017-Absent,02/01/2017-Present,01/31/2017-Absent,01/30/2017-Present,01/29/2017-Absent,01/28/2017-Present,01/27/2017-Absent,01/26/2017-Present,01/25/2017-Absent,01/24/2017-Present,01/23/2017-Absent,01/22/2017-Present,01/21/2017-Absent,01/20/2017-Present,01/19/2017-Absent,01/18/2017-Present,01/17/2017-Absent,01/16/2017-Present,01/15/2017-Absent,01/14/2017-Present,01/13/2017-Absent,01/12/2017-Present,01/11/2017-Absent,01/10/2017-Present,01/09/2017-Absent,01/08/2017-Present,01/07/2017-Absent,01/06/2017-Present,01/05/2017-Absent,01/04/2017-Present,01/03/2017-Absent,01/02/2017-Present,01/01/2017-Absent,";
		//String[] str=attendanceRecord.split(",");
		String str1="";
		String str2="";
		String str3="";
		/*for(int i=0;i<str.length/2;i++){
			str1=str[i]+","+str1;
		}for(int i=0;i>=str.length/3 && i<2*str.length/3;i++){
			str2=str[i]+","+str2;
		}for(int i=0;i>=2*str.length/3;i++){
			str3=str[i]+","+str3;
		}*/
		System.out.println("here is str1 :"+str1+"\n");
		System.out.println("here is str2 :"+str2+"\n");
		System.out.println("here is str2 :"+str2+"\n");
		System.out.println(attendanceRecord);
		httpSession.setAttribute("personRecord", attendanceRecord);
		//httpSession.setAttribute("personRecord2", str2);
		//httpSession.setAttribute("personRecord3", str3);
		response.sendRedirect("Hr.jsp");
	}

}