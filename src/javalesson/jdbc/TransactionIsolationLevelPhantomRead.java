package javalesson.jdbc;

import java.sql.*;

public class TransactionIsolationLevelPhantomRead {
    static String userName = "root";
    static String password = "1111";
    static String connectionURL = "jdbc:mysql://localhost:3306/MySQLConnectionLesson?useSSL=true";

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password);
             Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE );
            ResultSet resultSet = statement.executeQuery("SELECT count(*) FROM books");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
            new TransactionIsolationLevelRepiatableRead.OtherAction().start();
            Thread.sleep(2000);

            ResultSet resultSet1 = statement.executeQuery("SELECT count(*) FROM books");
            while (resultSet1.next()) {
                System.out.println(resultSet1.getInt(1));
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
                statement.executeUpdate("INSERT INTO books (name) VALUES ('Victory')");
                connection.commit();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}

