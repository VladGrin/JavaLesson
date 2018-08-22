package javalesson.encryption;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AES {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String str = "hello world";
        Cipher cipher = Cipher.getInstance("AES");

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey key = keyGenerator.generateKey();

//        SecretKeySpec key = new SecretKeySpec("Bar12345Bar12345".getBytes(), "AES"); //16 byte
        cipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] bytes = cipher.doFinal(str.getBytes());
        for (byte b : bytes) {
            System.out.print(b + " ");
        }

        System.out.println("\n-------------------------");
        Cipher decript = Cipher.getInstance("AES");
        decript.init(Cipher.DECRYPT_MODE , key);
        byte[] decripterBytes = decript.doFinal(bytes);
        for (byte b : decripterBytes) {
            System.out.print((char) b);
        }
    }
}
