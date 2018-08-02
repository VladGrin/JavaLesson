package javalesson.stepic;


import java.util.Arrays;

public class AsciiCharSequenceEx {
    public static void main(String[] args){
        byte[] chars = {'a','s','d','f','g'};
        CharSequence charSequence = new AsciiCharSequence(chars);
        charSequence.length();
        System.out.println(charSequence.length());
        System.out.println(charSequence.charAt(1));
        System.out.println(charSequence.subSequence(1,3).charAt(0));
        System.out.println(charSequence.subSequence(1,3).charAt(1));
        System.out.println(charSequence.subSequence(1,4).charAt(2));
        System.out.println(charSequence.subSequence(1,4).toString());

    }
}

class AsciiCharSequence implements CharSequence {
    private byte[] byteArray;

    public AsciiCharSequence(byte[] byteArray) {
        this.byteArray = byteArray;
    }

    @Override
    public int length() {
        return byteArray.length;
    }

    @Override
    public char charAt(int index) {
        return (char) byteArray[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] bytes = new byte[end - start];
        int i = 0;
        int j = start;
        while (j != end) {
            bytes[i++] = byteArray[j++];
        }
        return new AsciiCharSequence(bytes);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(byte bytes : this.byteArray){
            stringBuilder.append((char)bytes);
        }
        return stringBuilder.toString();
    }
}

