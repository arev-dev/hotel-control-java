package DAL;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class ComunDB {

    private static String connectionString = "jdbc:mysql://localhost:3306/HotelDb?user=root&password=emmanuelle";


    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new Driver());
        Connection connection = DriverManager.getConnection(connectionString);
        return connection;
    }
    public static PreparedStatement createPS(Connection connection, String sql) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(sql);
        return ps;
    }
    public static ResultSet getRS(PreparedStatement ps) throws SQLException{
        ResultSet resultSet = ps.executeQuery();
        return resultSet;
    }
}