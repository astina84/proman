package web;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;



public class Init implements ServletContextListener {

	public Init(){
		
		System.out.println("Init File geladen");
		
	}
        
    public void contextDestroyed(ServletContextEvent sce) {
    }
    
    private void contextInitialized2(ServletContext servletContext)
    throws Exception {
    	 InitialContext enc = new InitialContext();
         DataSource dataSource = (DataSource)enc.lookup("java:comp/env/datasource");
         DataAccessObject.setDataSource(dataSource);
    }

    public void contextInitialized(ServletContextEvent sce) {
         ServletContext servletContext = sce.getServletContext();
        try {
           contextInitialized2(servletContext);
        }
        catch (Exception e)
        {
         //  System.out.println(e);
          throw new RuntimeException(e); 
           
        }
        
    }
}