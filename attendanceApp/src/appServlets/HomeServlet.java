package appServlets;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ServiceProvider;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession httpSession=request.getSession();
		httpSession.setAttribute("pass", null);
		httpSession.setAttribute("pass1", null);
		httpSession.setAttribute("singleDate", null);
		httpSession.setAttribute("batchDate", null);
		
		String attendenceCall=request.getParameter("attendenceCall");
		String monthlyView=request.getParameter("view");
		String tableFormat=request.getParameter("tableFormat");
		String calendarFormat=request.getParameter("calendarFormat");
		String userName=(String) httpSession.getAttribute("user");
		if(attendenceCall!=null){
				httpSession.setAttribute("rollCall", attendenceCall);
		}
		if(monthlyView!=null){
			System.out.println("view:"+monthlyView);
			if(monthlyView.equals("intable")){
			
			httpSession.setAttribute("pass", "ok");
			}else{
			httpSession.setAttribute("pass1", "ok");
			}
		}
		ServiceProvider serviceProvider=new ServiceProvider();
		if(tableFormat!=null){
			System.out.println(tableFormat);
			String fullRecord=serviceProvider.setMonthlytableView(userName,tableFormat);
			System.out.println("size of list"+fullRecord.length());
			httpSession.setAttribute("batchDate", fullRecord);
		}
		if(calendarFormat!=null){
			System.out.println(calendarFormat);
			String fullRecord=serviceProvider.setMonthlytableView(userName,calendarFormat);
			httpSession.setAttribute("singleDate", fullRecord);
		}
		
		response.sendRedirect("EmployeeHome.jsp");
	}

}
