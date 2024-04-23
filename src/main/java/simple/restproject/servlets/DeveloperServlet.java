package simple.restproject.servlets;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import simple.restproject.restHandlerService.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns =  "/rest/*")
@Slf4j
public class DeveloperServlet extends HttpServlet {
    private RestHandler getHandler;
    private RestHandler deleteHandler;
    private RestHandler insertHandler;
    private RestHandler updateHandler;
    //for mock tests
    public void setRestGetHandlerService(RestGetHandlerService getHandler){
        this.getHandler = getHandler;
    }
    public void setRestInsertHandlerService(RestInsertHandlerService insertHandler){
        this.insertHandler = insertHandler;
    }
    public void setRestUpdateHandlerService(RestUpdateHandlerService updateHandler){
        this.updateHandler = updateHandler;
    }
    public void setRestDeleteHandlerService(RestDeleteHandlerService deleteHandler){
        this.deleteHandler = deleteHandler;
    }

    public DeveloperServlet() throws SQLException, IOException {
    }

    @Override
    public void init(){
        final Object getHandler = getServletContext().getAttribute("getHandler");
        final Object deleteHandler = getServletContext().getAttribute("deleteHandler");
        final Object insertHandler = getServletContext().getAttribute("insertHandler");
        final Object updateHandler = getServletContext().getAttribute("updateHandler");
        this.getHandler =   (RestHandler) getHandler;
        this.deleteHandler = (RestHandler) deleteHandler;
        this.insertHandler = (RestHandler) insertHandler;
        this.updateHandler = (RestHandler) updateHandler;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        log.info("Request came {} to URI: {}", request.getMethod(), request.getRequestURI());
        String pathInfo = request.getPathInfo();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/HTML; charset=UTF-8");
        try {
            String userResponse = getHandler.handleRestRequest(pathInfo).orElseThrow(() -> new SQLException());
            response.setContentType("application/json; charset=UTF-8");
            response.setStatus(200);
            PrintWriter out = response.getWriter();
            out.write(userResponse);
        } catch (SQLException e){
            e.printStackTrace();
            log.error(e.getMessage());
            PrintWriter out = response.getWriter();
      //      if (pathInfo.contains("developer")) {
                out.write("Developer not found");
        //    }
            response.setStatus(404);
        } catch (JsonProcessingException e){
            e.printStackTrace();
            log.error(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        log.info("Request came {} to URI: {}", request.getMethod(), request.getRequestURI());
        String pathInfo = request.getPathInfo();
        request.setCharacterEncoding("UTF-8");
       try{
           int generated_id = insertHandler.handleRestRequest(pathInfo, request);
           response.setContentType("text/HTML; charset=UTF-8");
           if (pathInfo.contains("developer")) {
               response.getWriter().write(String.format("Developer created: { \"id\" : \"%d\" }", generated_id));
               response.setStatus(201);
           }
       }catch (SQLException ex){
           log.error(ex.getMessage(), ex);
           response.setContentType("application/json; charset=UTF-8");
           response.getWriter().write("Developer not added");
           response.setStatus(404);
       }
    }

@Override
protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    log.info("Request came {} to URI: {}", request.getMethod(), request.getRequestURI());
    String pathInfo = request.getPathInfo();
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/HTML; charset=UTF-8");
    try {
        long deleted_rows = deleteHandler.handleRestRequest(pathInfo, request);
           if (deleted_rows != 0) {
                response.setStatus(200);
               response.getWriter().write(String.format("Deleted %d developer", deleted_rows));
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.setStatus(400);
            if (pathInfo.contains("developer")) {
                response.getWriter().write("Developer not found");
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("Request came {} to URI: {}", request.getMethod(), request.getRequestURI());
        String pathInfo = request.getPathInfo();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/HTML; charset=UTF-8");
        try {
           updateHandler.handleRestRequest(pathInfo, request);
            response.getWriter().write("Developer updated");
           response.setStatus(200);
        } catch (SQLException ex) {
            ex.printStackTrace();
            response.setStatus(400);
            response.getWriter().write("Developer not updated");
        }
    }
}
