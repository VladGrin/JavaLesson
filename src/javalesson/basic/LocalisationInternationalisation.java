package javalesson.basic;

import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalisationInternationalisation {
    public static void main(String[] args) {

        ResourceBundle bundleDefault = ResourceBundle.getBundle("resources");
//        ResourceBundle bundleDefaultEn = ResourceBundle.getBundle("resources_en", new Locale("en", "US"));

        System.out.println(bundleDefault.getString("somevalue"));
    }
}
