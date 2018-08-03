package javalesson.stepic;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CountControlSum {
    public static void main(String[] args) throws IOException {
        final int checkSum = checkSumOfStream(
                new ByteArrayInputStream(
                        new byte[]{0x33, 0x45, 0x01})
        );
        System.out.println(checkSum);
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int controlSum = 0;
        int data;
        while ((data = inputStream.read()) >= 0) {
            if (data == -1) {
                return 0;
            }
            controlSum = Integer.rotateLeft(controlSum, 1) ^ data;
        }
        return controlSum;
    }
}
