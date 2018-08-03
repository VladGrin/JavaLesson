package javalesson.stepic;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        byte[] b = new byte[]{65, 13, 10, 10, 13};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(b);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(5);
        transform(byteArrayInputStream, byteArrayOutputStream);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        for (int i : bytes) {
            System.out.println(i);
        }
//        transform(System.in, System.out);
    }

    private static void transform(InputStream inputStream, OutputStream outputStream) throws IOException {
        int first = inputStream.read();
        int next;
        while (first >= 0) {
            next = inputStream.read();
            if (!(first == 13 && next == 10)) {
                outputStream.write(first);
            }
            first = next;
        }
        outputStream.flush();
    }
}
