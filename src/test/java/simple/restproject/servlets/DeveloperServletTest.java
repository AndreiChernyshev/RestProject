package simple.restproject.servlets;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import simple.restproject.model.Developer;
import simple.restproject.restHandlerService.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DeveloperServletTest {

    @BeforeEach
    void setUp() throws SQLException, IOException {
    }

    @Test
    void doGet() throws IOException, SQLException {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        String pathInfo = "/developer/1";
        when(request.getPathInfo()).thenReturn(pathInfo);
        when(request.getMethod()).thenReturn("GET");
        when(request.getRequestURI()).thenReturn(pathInfo);

        Developer developer = new Developer(1, "Иван Смирнов", 30, "Институт");
        RestGetHandlerService restGetHandlerService = Mockito.mock(RestGetHandlerService.class);
        Mockito.when(restGetHandlerService.handleRestRequest(pathInfo)).thenReturn(Optional.ofNullable(developer.toString()));

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);


        DeveloperServlet developerServlet = new DeveloperServlet();
        developerServlet.setRestGetHandlerService(restGetHandlerService);
        developerServlet.doGet(request, response);

        writer.flush();
        String result = stringWriter.toString();
        assertEquals(developer.toString(), result);
    }
    @Test
    void doDelete() throws IOException, SQLException, ServletException {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        String pathInfo = "/developer/1";
        when(request.getPathInfo()).thenReturn(pathInfo);
        when(request.getMethod()).thenReturn("DELETE");
        when(request.getRequestURI()).thenReturn(pathInfo);

        int i = 1;
        RestDeleteHandlerService restDeleteHandlerService = Mockito.mock(RestDeleteHandlerService.class);
        Mockito.when(restDeleteHandlerService.handleRestRequest(pathInfo,request)).thenReturn(i);


        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        DeveloperServlet developerServlet = new DeveloperServlet();
        developerServlet.setRestDeleteHandlerService(restDeleteHandlerService);
        developerServlet.doDelete(request, response);

        writer.flush();
        String result = stringWriter.toString();
        assertEquals("Deleted 1 developer", result);
       }

    @Test
    void doPost() throws IOException, SQLException {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        String pathInfo = "/developer/";
        when(request.getPathInfo()).thenReturn(pathInfo);
        when(request.getMethod()).thenReturn("POST");
        when(request.getRequestURI()).thenReturn(pathInfo);

        int i = 1;
        RestInsertHandlerService restInsertHandlerService = Mockito.mock(RestInsertHandlerService.class);
        Mockito.when(restInsertHandlerService.handleRestRequest(pathInfo,request)).thenReturn(i);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        DeveloperServlet developerServlet = new DeveloperServlet();
        developerServlet.setRestInsertHandlerService(restInsertHandlerService);
        developerServlet.doPost(request, response);
        writer.flush();

        String result = stringWriter.toString();
        String expectedResult = "Developer created: { \"id\" : \"1\" }";
        assertEquals(expectedResult, result );

    }
    @Test
    void doPut() throws IOException, SQLException, ServletException {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        String pathInfo = "/developer/1";
        when(request.getPathInfo()).thenReturn(pathInfo);
        when(request.getMethod()).thenReturn("PUT");
        when(request.getRequestURI()).thenReturn(pathInfo);

        int i = 1;
        RestUpdateHandlerService restUpdateHandlerService = Mockito.mock(RestUpdateHandlerService.class);
        Mockito.when(restUpdateHandlerService.handleRestRequest(pathInfo,request)).thenReturn(i);

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        DeveloperServlet developerServlet = new DeveloperServlet();
        developerServlet.setRestUpdateHandlerService(restUpdateHandlerService);
        developerServlet.doPut(request, response);

        String result = stringWriter.toString();
        assertEquals("Developer updated", result);

    }

    @AfterEach
    void tearDown() {
    }
}