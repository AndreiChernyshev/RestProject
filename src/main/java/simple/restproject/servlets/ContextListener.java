package simple.restproject.servlets;

import simple.restproject.dao.ConnectionManagerJDBC;
import simple.restproject.dao.DeveloperDao;
import simple.restproject.dao.DeveloperDaoJDBC;
import simple.restproject.restHandlerService.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.sql.SQLException;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        final ServletContext servletContext = servletContextEvent.getServletContext();
        DeveloperDao developerDaoJDBC;
        RestHandler restGetHandlerService;
        RestHandler restDeleteHandlerService;
        RestHandler restInsertHandlerService;
        RestHandler restUpdateHandlerService;
        try {
            developerDaoJDBC = new DeveloperDaoJDBC(ConnectionManagerJDBC.getInstance().getConnection());
            restGetHandlerService    = new RestGetHandlerService();
            restDeleteHandlerService = new RestDeleteHandlerService();
            restInsertHandlerService = new RestInsertHandlerService();
            restUpdateHandlerService = new RestUpdateHandlerService();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
                }
        servletContext.setAttribute("developerDao", developerDaoJDBC);
        servletContext.setAttribute("getHandler", restGetHandlerService);
        servletContext.setAttribute("deleteHandler", restDeleteHandlerService);
        servletContext.setAttribute("insertHandler", restInsertHandlerService);
        servletContext.setAttribute("updateHandler", restUpdateHandlerService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
