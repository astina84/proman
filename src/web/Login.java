package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
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
				
		String username = null;
		String password = null;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		username = request.getParameter("username").toString();
		password = request.getParameter("password").toString();
  	  
  	  	if(request.getParameter("username") != null && request.getParameter("username") != "" && request.getParameter("password") != null && request.getParameter("password") != "")
  		{
  		  		
		  	HttpSession session = request.getSession(true);
			
  		  	MitarbeiterDTO mitarbeiter = new MitarbeiterDAO().checkPassword(username, password);

			if (mitarbeiter != null)
			{
				session.setAttribute("username", mitarbeiter.getVorname());
					
		    	System.out.println("login = erfolgreich");
		    			    		    	
				RequestDispatcher view=request.getRequestDispatcher("./JSP/test.jsp");
				view.include(request, response);
  
//			    out.println("Sie haben sich angemeldet: " + session.getAttribute("username") +"<br>");
//			    out.println("Ihre ID: " + session.getId() + "<br>");
//			    out.println("erster Login: "+new Date(session.getCreationTime()) + "<br>");
			}
			else
			{
				System.out.println("login = fehlgeschlagen ( Benutzeranmeldung ) ");
				RequestDispatcher view=request.getRequestDispatcher("./JSP/login.jsp");
				view.include(request, response);
				session.invalidate();
			}

  		}else
  		{
  			System.out.println("login = fehlgeschlagen ( Felder leer ) ");
  			RequestDispatcher view=request.getRequestDispatcher("./JSP/login.jsp");
  			view.include(request, response);
  		}
  		
	}
		
	

}
