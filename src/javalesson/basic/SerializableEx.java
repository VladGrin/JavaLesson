package javalesson.basic;

import java.io.*;

public class SerializableEx {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        user.lifeLevel = 55;
        user.staticLevel = 60;
        Sword sword = new Sword();
        sword.level = 5;
        user.sword = sword;

        FileOutputStream fileOutputStream = new FileOutputStream("tempfile");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.close();

        user.staticLevel = 10;

        FileInputStream fileInputStream = new FileInputStream("tempfile");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        User newUser = (User)objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(newUser.lifeLevel);
        System.out.println(newUser.staticLevel);// статические поля не серриализуются
        System.out.println(newUser.sword.level);
    }

}
class User implements Serializable {
    int lifeLevel;
    static int staticLevel;
    Sword sword;
    transient Sword sword1; // не серриализуется
}
class Sword implements Serializable {
    int level;
}
class userChild extends User{

}
