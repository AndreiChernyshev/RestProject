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

public class RestInsertHandlerService implements RestHandler{
    private final DeveloperDao developerDao = new DeveloperDaoJDBC(ConnectionManagerJDBC.getInstance().getConnection());
    private final ObjectMapper objectMapper = new ObjectMapper();

    public RestInsertHandlerService() throws SQLException, IOException {
    }

    @Override
    public int handleRestRequest(String requestPath, HttpServletRequest request) throws SQLException, IOException {
        int generated_id = 0;
        if (requestPath.matches("^/developer/$")) {
            String bodyParams = request.getReader().lines().collect(Collectors.joining());
            Developer developer = objectMapper.readValue(bodyParams, Developer.class);
            generated_id = developerDao.insertDeveloper(developer);
        }
        return generated_id;
    }

    @Override
    public Optional<String> handleRestRequest(String requestPath) throws SQLException, JsonProcessingException {
        throw new UnsupportedOperationException();
    }
}
