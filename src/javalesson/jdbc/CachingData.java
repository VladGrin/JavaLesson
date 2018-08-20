package javalesson.jdbc;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class CachingData {
    static String userName = "root";
    static String password = "1111";
    static String connectionURL = "jdbc:mysql://localhost:3306/MySQLConnectionLesson?useSSL=true";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = getData();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("id") + "  " + resultSet.getString("name"));
        }
        CachedRowSet cachedRowSet = (CachedRowSet) resultSet;
        cachedRowSet.setUrl(connectionURL);
        cachedRowSet.setUsername(userName);
        cachedRowSet.setPassword(password);
//        cachedRowSet.setCommand("SELECT * FROM books WHERE id = ?");
//        cachedRowSet.setInt(1, 2);
//        cachedRowSet.setPageSize(20);
//        cachedRowSet.execute();
//
//        do {
//            while (cachedRowSet.next()) {
//                System.out.println(cachedRowSet.getInt("id") + "  " + cachedRowSet.getString("name"));
//            }
//        } while (cachedRowSet.nextPage());

        CachedRowSet cachedRowSet1 = (CachedRowSet) resultSet;
        cachedRowSet1.setTableName("Books");
        cachedRowSet1.absolute(2);
        cachedRowSet1.deleteRow();
        cachedRowSet1.beforeFirst();
        while (cachedRowSet1.next()){
            System.out.println(cachedRowSet1.getInt("id") + "  " + cachedRowSet1.getString("name"));
        }
        cachedRowSet1.acceptChanges(DriverManager.getConnection(connectionURL, userName, password));
//        cachedRowSet1.setUrl(connectionURL);
//        cachedRowSet1.setUsername(userName);
//        cachedRowSet1.setPassword(password);
//        cachedRowSet1.acceptChanges();
    }

    static ResultSet getData() throws ClassNotFoundException, SQLException {
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

            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet cachedRowSet = factory.createCachedRowSet();


            Statement statement1 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement1.executeQuery("SELECT * FROM books");
            cachedRowSet.populate(resultSet);
            return cachedRowSet;
        }
    }
}
