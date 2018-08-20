package javalesson.jdbc;

import java.sql.*;
import java.util.Stack;

public class UpdateResultSet {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "1111";
        String connectionURL = "jdbc:mysql://localhost:3306/MySQLConnectionLesson?useSSL=true";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionURL, userName, password);
            Statement statement = connection.createStatement()){
            statement.execute("DROP TABLE IF EXISTS Books");
            statement.execute("DROP TABLE IF EXISTS Users");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS books " +
                    "(id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL , PRIMARY KEY (id));");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users " +
                    "(id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL , password CHAR(30) NOT NULL, PRIMARY KEY (id));");

            statement.executeUpdate("INSERT INTO books (name) VALUES ('Robin Good')");
            statement.executeUpdate("INSERT INTO books (name) VALUES ('Tarzan')");
            statement.executeUpdate("INSERT INTO books (name) VALUES ('King Kong')");
            statement.executeUpdate("INSERT INTO books (name) VALUES ('One')");

            statement.executeUpdate("INSERT INTO users (name, password) VALUES ('Bob','123')");
            statement.executeUpdate("INSERT INTO users (name, password) VALUES ('Rick', '658')");
            statement.executeUpdate("INSERT INTO users (name, password) VALUES ('Mark', '852')");

            Statement statement1 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            PreparedStatement preparedStatement = connection.prepareStatement("sql", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement1.executeQuery("SELECT * FROM books");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id") + "  " +resultSet.getString("name") );
            }
            resultSet.last();
            resultSet.updateString("name", "Big Ben");
            resultSet.updateRow();

            resultSet.moveToInsertRow();
            resultSet.updateString("name", "Crow");
            resultSet.insertRow();

            resultSet.absolute(2);
            resultSet.deleteRow();

            System.out.println("---------------------------------");

            resultSet.beforeFirst();
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id") + "  " +resultSet.getString("name") );
            }
        }
    }
}
