package javalesson.basic;

public class AutoBox {
    public static void main(String[] args) {
        String s1 = "aaa";
        String s2 = "aaa";
        String s3 = new String("aaa");
        System.out.println(s1.equals(s3));
        Object o1 = new Object();
        Object o2 = new Object();
        System.out.println(o1==o2);
        Integer a = 127;
        Integer b = 127;
        Integer c = new Integer("127");
        System.out.println(a==b);
        System.out.println(a==c);
    }
}
