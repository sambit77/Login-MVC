package login.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.db.Users;
import login.model.UsersDao;
import login.service.UserService;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login.controller.Forgot")
public class Forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Forgot() {
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

		 String email = request.getParameter("email");
		
		
	
		
		 
		 Users ob  = new Users();
		 ob.setEmail(email);
		 
	     String pass = UsersDao.getPassword(ob);
	     
	     if(pass != null)
	     {
	    	ob.setPassword(pass);
	    	UserService.sendPassword(ob);
	     }
	     else
	     {
	    	 String msg1 = "Invalid Email Address";
			 response.sendRedirect("forgot.jsp?msg="+msg1);
	     }
		
		 
	}

}
