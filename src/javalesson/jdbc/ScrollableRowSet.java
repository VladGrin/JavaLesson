package javalesson.jdbc;

import java.sql.*;

public class ScrollableRowSet {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "1111";
        String connectionUrl = "jdbc:mysql://localhost:3306/MySQLConnectionLesson?useSSL=true";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {

            statement.execute("DROP TABLE IF EXISTS books;");
            statement.execute("DROP TABLE IF EXISTS users;");
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

            Statement statement1 = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            PreparedStatement preparedStatement = connection.prepareStatement("", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement1.executeQuery("SELECT * FROM books");
            if (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
            if (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
            if (resultSet.previous()) {
                System.out.println(resultSet.getString("name"));
            }
            if (resultSet.relative(2)) {
                System.out.println(resultSet.getString("name"));
            }
            if (resultSet.relative(-2)) {
                System.out.println(resultSet.getString("name"));
            }
            if (resultSet.absolute(4)){
                System.out.println(resultSet.getString("name"));
            }
            if (resultSet.first()){
                System.out.println(resultSet.getString("name"));
            }
            if (resultSet.last()){
                System.out.println(resultSet.getString("name"));
            }
        }
    }
}
