package simple.restproject.restHandlerService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import simple.restproject.dao.ConnectionManagerJDBC;
import simple.restproject.dao.DeveloperDao;
import simple.restproject.dao.DeveloperDaoJDBC;
import simple.restproject.model.Developer;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class RestGetHandlerService implements RestHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private  DeveloperDao developerDao = new DeveloperDaoJDBC(ConnectionManagerJDBC.getInstance().getConnection());

    public RestGetHandlerService() throws SQLException, IOException {
    }

    @Override
    public Optional<String> handleRestRequest(String requestPath) throws SQLException, JsonProcessingException {
        if(requestPath.matches("^/developer/\\d+$")){
            String developerIdParam = parseID(requestPath);
            int developerId = Integer.parseInt(developerIdParam);
            Developer developer = developerDao.findDeveloperById(developerId).orElseThrow(() ->new SQLException());
            final String developerJsonRepresentation = objectMapper.writeValueAsString(developer);
            return Optional.ofNullable(developerJsonRepresentation);
        }
        return Optional.empty();
    }

    @Override
    public int handleRestRequest(String requestPath, HttpServletRequest request) throws SQLException, IOException {
        return 0;
    }
    private String parseID(String requestPath) {
        String[] parts = requestPath.split("/");
        return parts[2];
    }
}
