package javalesson.jdbc;

import java.sql.*;

public class TransactionIsolationLevelRepiatableRead {
    static String userName = "root";
    static String password = "1111";
    static String connectionURL = "jdbc:mysql://localhost:3306/MySQLConnectionLesson?useSSL=true";

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password);
             Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
            }
            new OtherAction().start();
            Thread.sleep(2000);

            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM books");
            while (resultSet1.next()) {
                System.out.println(resultSet1.getInt("id") + " " + resultSet1.getString("name"));
            }
        }
    }
    static class OtherAction extends Thread {
        @Override
        public void run() {
            try (Connection connection = DriverManager.getConnection(connectionURL, userName, password);
                 Statement statement = connection.createStatement()) {
                connection.setAutoCommit(false);
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
                statement.executeUpdate("UPDATE books SET name = 'Tom And Jerry' WHERE id = 1");
                connection.commit();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
