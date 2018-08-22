package javalesson.encryption;

import javax.crypto.*;
import java.security.*;

public class RSA {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String str = "hello world";

        Cipher cipher = Cipher.getInstance("RSA");

        KeyPairGenerator pairGenerator = KeyPairGenerator.getInstance("RSA");
//        SecureRandom random = new SecureRandom();
//        pairGenerator.initialize(512, random);
        KeyPair keyPair = pairGenerator.generateKeyPair();
        Key publicKey = keyPair.getPublic();
        Key privateKey = keyPair.getPrivate();

        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] bytes = cipher.doFinal(str.getBytes());
        for (byte b : bytes) {
            System.out.print(b + " ");
        }

        System.out.println("\n-------------------------");
        Cipher decript = Cipher.getInstance("RSA");
        decript.init(Cipher.DECRYPT_MODE , privateKey);
        byte[] decripterBytes = decript.doFinal(bytes);
        for (byte b : decripterBytes) {
            System.out.print((char) b);
        }
    }
}
