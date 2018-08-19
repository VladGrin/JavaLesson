package javalesson.jdbc;

import sun.plugin.javascript.navig.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class BLOBJDBC {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        String userName = "root";
        String password = "1111";
        String connectionUrl = "jdbc:mysql://localhost:3306/MySQLConnectionLesson?useSSL=true";
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionUrl, userName, password);
             Statement statement = connection.createStatement()) {

            statement.execute("DROP TABLE IF EXISTS books;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS books " +
                    "(id MEDIUMINT NOT NULL AUTO_INCREMENT, " +
                    "name CHAR(30) NOT NULL , img LONGBLOB, PRIMARY KEY (id));");

            BufferedImage image = ImageIO.read(new File("picture.jpg"));
            Blob blob = connection.createBlob();
            try (OutputStream outputStream = blob.setBinaryStream(1)) {
                ImageIO.write(image, "jpg", outputStream);
            }

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books (name, img) values (?,?)");
            preparedStatement.setString(1, "inferno");
            preparedStatement.setBlob(2, blob);
            preparedStatement.execute();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
            while (resultSet.next()){
                Blob blob1 = resultSet.getBlob("img");
                BufferedImage image1 = ImageIO.read(blob.getBinaryStream());
                File outputFile = new File("saved.png");
                ImageIO.write(image1, "png", outputFile);

            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
