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
		httpSession.setAttribute("personRecord", attendanceRecord);
		response.sendRedirect("Hr.jsp");
	}

}
