package javalesson.jdbc;

import java.sql.*;

public class Metadata {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "1111";
        String connectionURL = "jdbc:mysql://localhost:3306/MySQLConnectionLesson?useSSL=true";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password);
             Statement statement = connection.createStatement()) {
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

            DatabaseMetaData databaseMetaData = connection.getMetaData();
            databaseMetaData.nullPlusNonNullIsNull();
            ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[]{"Table"});
            while (resultSet.next()) {
//                System.out.println(resultSet.getString(1));
//                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
//                System.out.println(resultSet.getString(4));
            }
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM books");
            ResultSetMetaData resultSetMetaData = resultSet1.getMetaData();
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                System.out.println(resultSetMetaData.getColumnLabel(i) + " " + resultSetMetaData.getColumnType(i));
            }
        }
    }
}
