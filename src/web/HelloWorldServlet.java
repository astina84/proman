package web;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = null;
		String username = null;
		String userpass = null;
		String strQuery= null;
		
		System.out.println("MySQL Connect Example");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection conn = null;
		//## Datenbank Angaben
		String url="jdbc:mysql://dd8516.kasserver.com/";
		String dbName = "d0140088";
		String driver = "com.mysql.jdbc.Driver";
		String dbUsername = "d0140088";
		String dbPassword = "u1337freak";
		
		
		System.out.println("Connection");
		
		Statement st=null;
		ResultSet rs=null;
		HttpSession session = request.getSession(true);
		
		try {
		   
		    Class.forName(driver).newInstance();
		    conn = DriverManager.getConnection(url+dbName,dbUsername,dbPassword);

		    
		    if(request.getParameter("username") != null &&
		       request.getParameter("username") != ""   &&
		       request.getParameter("password") != null &&
		       request.getParameter("password") != "")
		    {
		    	  username = request.getParameter("username").toString();
		    	  userpass = request.getParameter("password").toString();
		    	  
		    	  strQuery="select * from Mitarbeiter where Username='"+username+"' and  Password='"+userpass+"'";
		    	  
		    	  st = conn.createStatement();
		    	  rs = st.executeQuery(strQuery);
		    	  
		    	  int count=0;
		    	
		    	  while(rs.next())
		    	  {
			    	  session.setAttribute("username",rs.getString(2));
			    	  count++;
		    	  }
		    	  
		    	  if(count>0)
		    	  {
		    		  System.out.println("login = erfolgreich");
		    		  		    		  
			    	  out.println("Sie haben sich angemeldet: " + session.getAttribute("username") +"<br>");
			    	  out.println("Ihre ID: " + session.getId() + "<br>");
			    	  out.println("erster Login: "+new Date(session.getCreationTime()) + "<br>");
			    	  
		    	  }
		    	  else
		    	  {
		    		  System.out.println(" login = fehlgeschlagen ( Benutzeranmeldung ) ");
		    		  RequestDispatcher view=request.getRequestDispatcher("./JSP/login.jsp");
		    		  view.include(request, response);
			    	  session.invalidate();
		    	  }
		    }
		    else
		    {
		    	  System.out.println(" login = fehlgeschlagen ( Felder leer ) ");
	    		  RequestDispatcher view=request.getRequestDispatcher("./JSP/login.jsp");
	    		  view.include(request, response);
		    	  session.invalidate();
	    	}
	//    	System.out.println("Connected to the database"); 
	    	conn.close();
	//      System.out.println("Disconnected from database");
	        
		    } catch(Throwable t) {
					out.println("<PRE>");
					t.printStackTrace(out);
		 			out.println("</PRE>");
		    }

		    out.close();
	}

}
