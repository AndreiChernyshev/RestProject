package simple.restproject.restHandlerService;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public interface RestHandler {
    Optional<String> handleRestRequest(String requestPath) throws SQLException, JsonProcessingException;

    int handleRestRequest(String requestPath, HttpServletRequest request) throws SQLException, IOException;
}
