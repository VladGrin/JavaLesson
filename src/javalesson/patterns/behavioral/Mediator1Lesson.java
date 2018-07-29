package javalesson.patterns.behavioral;

import java.util.ArrayList;
import java.util.List;

public class Mediator1Lesson {
    public static void main(String[] args) {
        Chat chat = new SimpleTextChat();
        User admin = new Admin(chat, "Admin");
        User user1 = new SimpleUser(chat, "User1");
        User user2 = new SimpleUser(chat, "User2");
        ((SimpleTextChat) chat).setAdmin(admin);
        ((SimpleTextChat) chat).addUserToChat(user1);
        ((SimpleTextChat) chat).addUserToChat(user2);

        user1.sendMessage("Hello, I am user 1");
        admin.sendMessage("I am admin.");
    }
}
interface Chat{
    void sendMessage(String message, User user);
}
interface User{
    void sendMessage(String message);
    void getMessage(String message);
}
class Admin implements User{
    Chat chat;
    String name;
    public Admin(Chat chat, String name) {
        this.chat = chat;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }
    @Override
    public void getMessage(String message) {
        System.out.println(this.name + " receiving message " + message + ".");
    }
}
class SimpleUser implements User{
    Chat chat;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SimpleUser(Chat chat, String name) {

        this.chat = chat;
        this.name = name;
    }

    @Override
    public void sendMessage(String message) {
        chat.sendMessage(message, this);
    }

    @Override
    public void getMessage(String message) {
        System.out.println(this.name + " receiving message " + message + ".");
    }
}
class SimpleTextChat implements Chat{
    User admin;
    List<User> users = new ArrayList<>();

    public void setAdmin(User admin) {
        this.admin = admin;
    }
    public void addUserToChat(User user){
        this.users.add(user);
    }

    @Override
    public void sendMessage(String message, User user) {
        for(User us : users){
            if(us != user){
                us.getMessage(message);
            }
        }
        admin.getMessage(message);
    }
}