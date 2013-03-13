package web;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


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
		    	  System.out.println(username + " " + userpass);
		    	  strQuery="select * from Mitarbeiter where Username='"+username+"' and  Password='"+userpass+"'";
		    	  System.out.println(strQuery);
		    	  st = conn.createStatement();
		    	  rs = st.executeQuery(strQuery);
		    	  int count=0;
		    	
		    	  while(rs.next())
		    	  {
			    	  session.setAttribute("username",rs.getString(1));
			    	  count++;
		    	  }
		    	  
		    	  if(count>0)
		    	  {
		    		  System.out.println("login");
			    	  out.println("Sie haben sich angemeldet"+ username);
		    	  }
		    	  else
		    	  {
			    	  out.println("Du musst es noch einmal Probieren");
		    	  }
		    }
		    else
		    {
	    	  out.println("Benutzername und Passwortfelder dürfen nicht leer sein !");
	    	}
	    	System.out.println("Connected to the database"); 
	    	conn.close();
	        System.out.println("Disconnected from database");
	        
		    } catch(Throwable t) {
					out.println("<PRE>");
					t.printStackTrace(out);
		 			out.println("</PRE>");
		    }

		    out.close();
	}

}
