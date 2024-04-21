package seccsion07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectDB {
    public static Connection getMySQLConnection() throws SQLException {
        Connection conn = null;
        String hostName = "localhost";
        String dbName = "EmployeeFPT";
        String userName ="root";
        String password = "";

        //String connection( chuoi ket noi)
        String connectionURL = "jdbc:mysql://"+hostName+":3306/"+dbName;
        conn = DriverManager.getConnection(connectionURL, userName, password);


        return conn;
    }

}
