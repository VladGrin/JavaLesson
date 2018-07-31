package javalesson.stepic;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTask1 {
    public static void main(String[] args) throws IOException {
        File javaExecutable = new File("F\\Example.txt");
        File javaExecutable1 = new File("F\\Example1");
        File javaExecutable2 = new File("/temp/temp1/textdoc.txt");
        File javaExecutable3 = new File("/temp/temp1/temp2/temp3/temp4");
        System.out.println(javaExecutable2.getPath());
        System.out.println(javaExecutable3.getPath());
        System.out.println(javaExecutable2.getAbsolutePath());
        System.out.println(javaExecutable3.getAbsolutePath());
        File f = new File("a\\b\\c\\file.txt");
        String s = f.getCanonicalPath();
        System.out.println(s);
        File f1 = new File("a\\b\\..\\file.txt");
        String s1 = f1.getCanonicalPath();
        System.out.println(s1);
        File f2 = new File("a\\..\\b\\c\\file.txt");
        String s2 = f2.getCanonicalPath();
        System.out.println(s2);
        File f3 = new File(".\\a\\b\\..\\b\\c\\.\\file.txt");
        String s3 = f3.getCanonicalPath();
        System.out.println(s3);
        File f4 = new File("a\\.\\b\\..\\c\\.\\file.txt");
        String s4 = f4.getCanonicalPath();
        System.out.println(s4);File f5 = new File("/a/.././b/../c/file.txt");
        String s5 = f5.getCanonicalPath();
        System.out.println(s5);
        File file = new File("temp.txt");
        Path path = file.toPath();
//        new FileInputStream(path);
        new FileInputStream(path.toFile());
//        Paths.newInputStream(path);
        Files.newInputStream(path);

        FileInputStream fileInputStream = new FileInputStream(file);
        try (DataInputStream dataInputStream = new DataInputStream(fileInputStream)) {
            // ...
        }
        FileInputStream fileInputStream1 = new FileInputStream(file);
        try (DataInputStream dataInputStream1 = new DataInputStream(fileInputStream1)) {
            // ...
        }
    }
}
