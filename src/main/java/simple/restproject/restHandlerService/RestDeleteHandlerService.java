package simple.restproject.restHandlerService;


import simple.restproject.dao.ConnectionManagerJDBC;
import simple.restproject.dao.DeveloperDao;
import simple.restproject.dao.DeveloperDaoJDBC;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;


public class RestDeleteHandlerService implements RestHandler{
    private final DeveloperDao developerDao = new DeveloperDaoJDBC(ConnectionManagerJDBC.getInstance().getConnection());
    public RestDeleteHandlerService() throws SQLException, IOException{}

    @Override
    public int handleRestRequest(String requestPath, HttpServletRequest request) throws SQLException, IOException {
        int updatedRows = 0;
        if (requestPath.matches("^/developer/\\d+$")) {
            String developerIdParam = parseID(requestPath);
            int developerId = Integer.parseInt(developerIdParam);
            updatedRows = developerDao.deleteDeveloperById(developerId);
        }
        return updatedRows;
    }
    @Override
    public Optional<String> handleRestRequest(String requestPath)  {
        throw new UnsupportedOperationException();
    }
    private String parseID(String requestPath) {
        String[] parts = requestPath.split("/");
        return parts[2];
    }
}
