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
import java.util.stream.Collectors;

public class RestUpdateHandlerService implements RestHandler {
    private final DeveloperDao developerDao = new DeveloperDaoJDBC(ConnectionManagerJDBC.getInstance().getConnection());
    private final ObjectMapper objectMapper = new ObjectMapper();

    public RestUpdateHandlerService() throws SQLException, IOException {
    }

    @Override
    public int handleRestRequest(String requestPath, HttpServletRequest request) throws SQLException, IOException {
        int updatedRows = 0;
        if (requestPath.matches("^/developer/\\d+$")) {
            String developerIdParam = parseID(requestPath);
            int developerId = Integer.parseInt(developerIdParam);
            String bodyParams = request.getReader().lines().collect(Collectors.joining());
            Developer developer = objectMapper.readValue(bodyParams, Developer.class);
            developer.setId(developerId);
            updatedRows = developerDao.updateDeveloper(developer);
        }
        return updatedRows;
    }
    @Override
    public Optional<String> handleRestRequest(String requestPath) throws SQLException, JsonProcessingException {
        throw new UnsupportedOperationException();
    }
    private String parseID(String requestPath) {
        String[] parts = requestPath.split("/");
        return parts[2];
    }
}
