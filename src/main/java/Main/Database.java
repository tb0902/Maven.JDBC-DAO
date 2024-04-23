package Main;



import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.*;

public class Database {
  private static String URL = "jdbc:mysql://localhost:3306/lot";
  private static String USERNAME = "root";
  private static String PASSWORD = "zipcode0";

  private Database() {

  }

  public static Connection getConnection() throws SQLException {
    Connection connection = null;
    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

    return connection;
  }

  public static void closeConnection(Connection connection) throws SQLException {
    connection.close();
  }

  public static void closeStatement(Statement statement) throws SQLException {
    statement.close();
  }

  public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
    preparedStatement.close();
  }

  public static void closeResultSet(ResultSet resultSet) throws SQLException {
    resultSet.close();
  }
}
