package simple.restproject.dao;

import simple.restproject.model.Developer;

import java.sql.SQLException;
import java.util.Optional;

public interface DeveloperDao {
    int insertDeveloper(Developer developer) throws SQLException;
    Optional<Developer> findDeveloperById(int id) throws SQLException;
    int updateDeveloper(Developer developer) throws SQLException;
    int deleteDeveloperById(int id) throws SQLException;
}
