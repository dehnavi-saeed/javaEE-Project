package observer;

import model.DA.DBConnectionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String dbURL = servletContextEvent.getServletContext().getInitParameter("dbURL");
        String dbUser = servletContextEvent.getServletContext().getInitParameter("dbUser");
        String dbPassword = servletContextEvent.getServletContext().getInitParameter("dbPassword");
        DBConnectionManager connectionManager = new DBConnectionManager(dbURL,dbUser,dbPassword);
        servletContextEvent.getServletContext().setAttribute("connectionManager",connectionManager);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
