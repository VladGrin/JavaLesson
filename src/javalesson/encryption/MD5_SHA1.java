package javalesson.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.stream.Stream;

public class MD5_SHA1 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String str = "hello world";
        // "SHA-1", "MD5"

        MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest(str.getBytes());

        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x ", b));
        }
        System.out.println(builder.toString());
    }
}
