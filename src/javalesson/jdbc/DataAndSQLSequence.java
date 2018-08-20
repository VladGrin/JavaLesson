package javalesson.jdbc;

import java.sql.*;

public class DataAndSQLSequence {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String userName = "root";
        String password = "1111";
        String connectionUrl = "jdbc:mysql://localhost:3306/MySQLConnectionLesson?useSSL=true";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {

            statement.execute("DROP TABLE IF EXISTS books;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS books " +
                    "(id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL , dt DATE, PRIMARY KEY (id));");

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books (name, dt) VALUES ('NAME', ?)");
            preparedStatement.setDate(1, new Date(1534791455196L));
            preparedStatement.execute();
            System.out.println(preparedStatement);

            statement.executeUpdate("INSERT INTO books (name, dt) VALUES ('NAME', '2018-08-20')");
            statement.executeUpdate("INSERT INTO books (name, dt) VALUES ('NAME1', {d '2018-08-21'})");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
            while (resultSet.next()){
                System.out.println(resultSet.getDate("dt"));
            }
        }
    }
}
