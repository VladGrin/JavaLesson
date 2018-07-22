package javalesson.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesEx {
    public static void main(String[] args) throws IOException {
        Properties defaultProperties = new Properties();
        defaultProperties.setProperty("bla", "default");

        Properties properties = new Properties(defaultProperties);
        properties.setProperty("one", "1");
        System.out.println(properties.getProperty("one"));

        FileOutputStream fileOutputStream = new FileOutputStream("my.properties");
        properties.store(fileOutputStream,"");

        FileInputStream fileInputStream = new FileInputStream("my.properties");
        properties.load(fileInputStream);
        System.out.println(properties.getProperty("one"));
        System.out.println(properties.getProperty("bla"));

    }
}
