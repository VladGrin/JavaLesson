package javalesson.jdbc;

import java.sql.*;

public class Transaction {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String userName = "root";
        String password = "1111";
        String connectionUrl = "jdbc:mysql://localhost:3306/MySQLConnectionLesson?useSSL=true";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = connection.createStatement()){
            connection.setAutoCommit(false);
            statement.execute("DROP TABLE IF EXISTS Books");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Books (id INT(4) AUTO_INCREMENT PRIMARY KEY, name VARCHAR (50) NOT NULL )");
            statement.executeUpdate("INSERT INTO Books (name) VALUES ('Robin Good')");
            statement.executeUpdate("INSERT INTO Books (name) VALUES ('Tarzan')");
            Savepoint savepoint = connection.setSavepoint();
            statement.executeUpdate("INSERT INTO Books (name) VALUES ('King Kong')");
            statement.executeUpdate("INSERT INTO Books (name) VALUES ('One')");

            connection.rollback(savepoint);
            connection.commit();
//            connection.releaseSavepoint(savepoint);

        }
    }
}
