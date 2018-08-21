package javalesson.jdbc;

import java.sql.*;

public class TransactionIsolationLavelDirtyReads {
    static String userName = "root";
    static String password = "1111";
    static String connectionURL = "jdbc:mysql://localhost:3306/MySQLConnectionLesson?useSSL=true";

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password);
             Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            statement.execute("UPDATE books SET name = 'Bingo' WHERE id= 1");
            new OtherAction().start();
            Thread.sleep(2000);
            connection.rollback();
        }
    }
    static class OtherAction extends Thread {
        @Override
        public void run() {
            try (Connection connection = DriverManager.getConnection(connectionURL, userName, password);
                 Statement statement = connection.createStatement()) {
                connection.setAutoCommit(false);
                connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
                ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}