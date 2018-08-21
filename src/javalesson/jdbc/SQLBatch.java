package javalesson.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLBatch {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "1111";
        String Url = "jdbc:mysql://localhost:3306/MySQLConnectionLesson?useSSL=true";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(Url, userName, password);
             Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            statement.addBatch("DROP TABLE IF EXISTS Books");
            statement.addBatch("CREATE TABLE IF NOT EXISTS Books (id INT(4) AUTO_INCREMENT PRIMARY KEY, name VARCHAR (50) NOT NULL)");
            statement.addBatch("INSERT INTO books (name) VALUES ('Robin Good')");
            statement.addBatch("INSERT INTO books (name) VALUES ('Tarzan')");
            statement.addBatch("INSERT INTO books (name) VALUES ('King Kong')");
            statement.addBatch("INSERT INTO books (name) VALUES ('One')");
            statement.addBatch("INSERT INTO books (name) VALUES ('Willoy')");
            if (statement.executeBatch().length == 7) {
                connection.commit();
            } else {
                connection.rollback();
            }
        }
    }
}
