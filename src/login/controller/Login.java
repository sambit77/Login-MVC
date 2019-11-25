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

/**
 * Servlet implementation class Login
 */
@WebServlet("/login.controller.Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		 String password  = request.getParameter("password");
		 
		 Users ob  = new Users();
		  ob.setEmail(email);
		  ob.setPassword(password);
		  
		  boolean status = UsersDao.doVallidate(ob);
		  if(status)
		  {
			 HttpSession session = request.getSession();
			 session.setAttribute("email", ob.getEmail());
			 response.sendRedirect("welcome.jsp");

		  }
		  else
		  {
			  String msg2 = "Invalid Email or Password";
			  response.sendRedirect("login.jsp?msg2="+msg2);
		  }
		 
		 
		 
	}

}
