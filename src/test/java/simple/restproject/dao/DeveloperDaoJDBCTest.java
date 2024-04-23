package simple.restproject.dao;

import org.junit.jupiter.api.*;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import simple.restproject.model.Developer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
@Testcontainers
class DeveloperDaoJDBCTest {
    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("restProject")
            .withUsername("postgres")
            .withPassword("postgres")
            .withInitScript("base.SQL");

    Connection connection;
    DeveloperDao developerDaoJDBC;
    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @BeforeEach
    void setUp() throws SQLException {
        Connection connection = DriverManager.getConnection(postgres.getJdbcUrl(), postgres.getUsername(), postgres.getPassword());
        developerDaoJDBC = new DeveloperDaoJDBC(connection);
    }

    @Test
    void insertDeveloper() throws SQLException {
        Developer developerToInsert = new Developer(101,"Андрей Чернышев", 44, "ОГТИ");
        int rowsToUpdate = developerDaoJDBC.insertDeveloper(developerToInsert);
        assertEquals(103, rowsToUpdate);
    }

    @Test
    void updateDeveloper() throws SQLException {
        Developer developerToUpdate = new Developer(10, "Андрей Чернышев", 44, "ОГТИ");
        int updated_row = developerDaoJDBC.updateDeveloper(developerToUpdate);
        assertEquals(1, updated_row);
    }

    @Test
    void deleteDeveloperById() throws SQLException {
        int idToDelete = 7;
        int updated_row = developerDaoJDBC.deleteDeveloperById(idToDelete);
        assertEquals(1, updated_row);

    }

    @Test
    void findDeveloperById() throws SQLException {
        int id = 5;
        String expectedDeveloper = "Developer(id=5, name=Яигорь Федоровби, age=63, education=Институт, projects=[Project(id=0, title=null, developerList=[])], phones=[PhoneNumber(id=0, ownerID=5, phoneType=UNKNOWN, phoneNumber=null)])";
        Developer actualDeveloper = developerDaoJDBC.findDeveloperById(id).get();
        assertEquals(expectedDeveloper, actualDeveloper.toString());

    }
}