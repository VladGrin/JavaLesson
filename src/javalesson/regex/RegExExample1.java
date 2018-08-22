package javalesson.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExExample1 {
    public static void main(String[] args) {
        System.out.println("aaa@gvgh.hgv".matches("\\b[A-Za-z0-9._%]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b"));

        Pattern pattern = Pattern.compile("ac");
        Matcher matcher = pattern.matcher("Jack is a boy acc");
        while (matcher.find()) {
            System.out.println(matcher.start() + " " + matcher.group());
        }

        String metaSymbols = "[]^$.|?*+()\\";

        Pattern pattern1 = Pattern.compile("1\\+1=2");
        Pattern pattern2 = Pattern.compile("\\Q1+1=2\\E"); // \\Q...\\Z
        Matcher matcher1 = pattern1.matcher("1+1=2");
        while (matcher1.find()) {
            System.out.println(matcher1.start() + " " + matcher1.group());
        }
    }
}
