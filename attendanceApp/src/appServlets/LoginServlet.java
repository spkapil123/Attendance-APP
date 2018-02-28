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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession();
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String person=request.getParameter("person");
		ServiceProvider validation=new ServiceProvider();
		boolean valid=validation.loginValidation(name, password,person);
		if(valid){
			httpSession.setAttribute("user", name);
			httpSession.setAttribute("person", person);
			if(person.equals("employee"))
				response.sendRedirect("EmployeeHome.jsp");
			else if(person.equals("hr")){
				String employees=validation.getEmployees();
				httpSession.setAttribute("employees", employees);
				response.sendRedirect("Hr.jsp");
			}
		}else{
			httpSession.setAttribute("error", "Invalid Credentials!!");
			response.sendRedirect("Login.jsp");
		}
		
	}

}
