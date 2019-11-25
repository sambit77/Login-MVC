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
 * Servlet implementation class ChangePassword
 */
@WebServlet("/login.controller.ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
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

		 String opass = request.getParameter("opass");
		 String npass  = request.getParameter("npass");
		 String cpass  = request.getParameter("cpass");
		
	
		
		 
		 Users ob  = new Users();
		  ob.setOpass(opass);
		  ob.setCpass(cpass);
		  ob.setNpass(npass);
		 
	     int status = UsersDao.doChangePassword(ob);
		 if(status == -1)
		 {
			 String msg = "New Password and Confirm Password dont match";
			 response.sendRedirect("changePassword.jsp?msg="+msg);
		 }
		 else if(status == -2 )
		 {
			 String msg = "Please enter correct old password ";
			 response.sendRedirect("changePassword.jsp?msg="+msg);
		 }
		 else if(status == -100)
		 {
			 String msg = "Unknown error  ";
			 response.sendRedirect("changePassword.jsp?msg="+msg);
		 }
		 else
		 {
			 String msg = "Password Updated  ";
			 response.sendRedirect("changePassword.jsp?msg="+msg);
			
		 }
		
	}

}
