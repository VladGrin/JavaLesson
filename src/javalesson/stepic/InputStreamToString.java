package javalesson.stepic;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class InputStreamToString {
    public static void main(String[] args) throws IOException {
        byte[] data = {48, 49, 50, 51};
        InputStream inputStream = new ByteArrayInputStream(data);
        String s = readAsString(inputStream, StandardCharsets.US_ASCII);
        System.out.println(s);
    }
    private static final int BUFFER_SIZE = 4 * 1024;
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        StringBuilder builder = new StringBuilder();
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        char[] chars = new char[4];
        int line;
        while ((line = reader.read(chars)) != -1) {
            builder.append(chars, 0, line);
        }
        return builder.toString();
    }
}
//    String str = "";
//    int line;
//    InputStreamReader reader = new InputStreamReader(inputStream, charset);
//    char[] chars = new char[40];
//        while((line = reader.read(chars)) != -1){
//                for (int i = 0; i < chars.length; i++) {
//        str += (char)chars[i];
//        }
//        }
//        return str;