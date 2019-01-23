package javalesson.propert;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertyEx {
    public static void main(String[] args) {
//        String country = "US";
//        String language = "EN";
//        Locale current = new Locale(language, country);
//        ResourceBundle rb = ResourceBundle.getBundle("property.text", current);
        Properties props = new Properties();
        try {
// установка значений экземпляру
            props.setProperty("db.driver", "com.mysql.jdbc.Driver");
// props.setProperty("db.url", "jdbc:mysql://127.0.0.1:3306/testphones");
            props.setProperty("db.user", "root");
            props.setProperty("db.password", "pass");
            props.setProperty("db.poolsize", "5");
// запись properties-файла в папку prop проекта
            props.store(new FileWriter("prop" + File.separator + "database.properties"),null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
// загрузка пар ключ-значение через поток ввода-вывода
            props.load(new FileReader("prop\\database.properties"));
        } catch (IOException e) {
            e.printStackTrace();        String driver = props.getProperty("db.driver");
// следующих двух ключей в файле нет
        String maxIdle = props.getProperty("db.maxIdle"); // будет присвоен null
// значение "20" будет присвоено ключу, если он не будет найден в файле
        String maxActive = props.getProperty("db.maxActive", "20");
        System.out.println(driver);
        System.out.println(maxIdle);
        System.out.println(maxActive);
        }


        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        System.out.println(url);
        System.out.println(user);
        System.out.println(pass);
    }
}
