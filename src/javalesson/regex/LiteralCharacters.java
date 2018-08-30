package javalesson.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LiteralCharacters {
    public static void main(String[] args) {
        //   Группы
        Pattern pattern = Pattern.compile("Set(Value)?");
        Matcher matcher = pattern.matcher("Set of SetValue");
        while (matcher.find()) {
            System.out.println(matcher.start() + " " + matcher.group());
        }

        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "$1 version")); // \\1
        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "$0 version")); // all regex
//        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "\\U1 version")); // uppercase
//        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "\\L1 version")); // lowercase
//        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "\\F1 version")); // first letter uppercase
//        System.out.println("EditPad Lite".replaceAll("EditPad (Lite|Pro)", "\\I1 version")); // each latter uppercase

        pattern = Pattern.compile("<([A-Z][A-Z0-9]*)[^>]*>.*?</\\1>");
        matcher = pattern.matcher("This is a <EM>first</EM> test");
        while (matcher.find()) {
            System.out.println(matcher.start() + " " + matcher.group());
        }
        matcher = pattern.matcher("Testing <B><I>text</I></B>");
        while (matcher.find()) {
            System.out.println(matcher.start() + " " + matcher.group());
        }

        System.out.println("the the".replaceAll("\\b(\\w+)\\s+\\1\\b", "$1"));

        //  Именованные группы
        System.out.println("abc".replaceAll("(?<Aletter>a)", "${Aletter}-"));
        pattern = Pattern.compile("<(?<tag>[A-Z][A-Z0-9]*)[^>]*>.*?</\\k<tag>>");
        matcher = pattern.matcher("This is a <EM>first</EM> test");
        while (matcher.find()) {
            System.out.println(matcher.start() + " " + matcher.group());
        }

        // Unicode
    }
}
