package javalesson.jdbc;

import java.sql.*;

public class MySQLConnection {
    public static void main(String[] args) throws ClassNotFoundException {
        String userName = "root";
        String password = "1111";
        String connectionUrl = "jdbc:mysql://localhost:3306/MySQLConnectionLesson";
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
            Statement statement = connection.createStatement()){

            statement.executeUpdate("DROP TABLE books;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS books (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL , PRIMARY KEY (id));");
            statement.executeUpdate("INSERT INTO books (name) values('INFERNO');");
            statement.executeUpdate("INSERT INTO books SET NAME = 'Barby';");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM books;");
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1));       //"id"
                System.out.println(resultSet.getString(2));   //"name"
                System.out.println("-------------------------");
            }

            ResultSet resultSet1 = statement.executeQuery("SELECT name FROM books WHERE id=1;");
            while (resultSet1.next()){
                System.out.println(resultSet1.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
