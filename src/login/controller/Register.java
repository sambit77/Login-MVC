package login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.db.Users;
import login.model.UsersDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/login.controller.Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		 String username = request.getParameter("username");
		 String password  = request.getParameter("password");
		 String email  = request.getParameter("email");
		 String phone  = request.getParameter("phone");
		 String regdno  = request.getParameter("regdno");
		 String college  = request.getParameter("college");
		 
		 Users u = new Users();
		 u.setUsername(username);
		 u.setPassword(password);
		 u.setEmail(email);
		 u.setPhone(phone);
		 u.setRegdno(regdno);
		 u.setCollege(college);
		 
		 int status = UsersDao.doRegister(u);
		 if(status > 0)
		 {
			 String msg1 = "User Registered";
			 response.sendRedirect("register.jsp?msg1="+msg1);
		
		 }
		 else
		 {
		 String msg2 = "User Not Registered";
		 response.sendRedirect("register.jsp?msg2="+msg2);
		 }
		
		
		
		
		
	}

}
