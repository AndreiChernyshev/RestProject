package simple.restproject.dao;
import java.util.Properties;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManagerJDBC {

        //making class a singleton
        private ConnectionManagerJDBC(){}
        private static ConnectionManagerJDBC connectionManager = new ConnectionManagerJDBC();
        public static synchronized ConnectionManagerJDBC getInstance() {
            if(connectionManager==null) {
                connectionManager = new ConnectionManagerJDBC();
            }
            return  connectionManager;
        }
        public Connection getConnection() {
            Connection conn = null;
            Properties prop= new Properties();
            try {
                prop.load(this.getClass().getClassLoader().getResourceAsStream("db.properties"));
                Class.forName("org.postgresql.Driver");
                conn= DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
            } catch (SQLException | IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return conn;
        }
    }
