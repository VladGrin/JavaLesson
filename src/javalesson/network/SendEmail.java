package javalesson.network;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class SendEmail {
    public static void main(String[] args) throws IOException, MessagingException {
        final Properties properties = new Properties();
        properties.load(SendEmail.class.getClassLoader().getResourceAsStream("mail.properties"));

        Session mailSession = Session.getDefaultInstance(properties);
        MimeMessage message = new MimeMessage(mailSession);
        message.setFrom(new InternetAddress("vlad5855051"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("margosha130103@gmail.com"));
        message.setSubject("hello");
        message.setText("This is my test message.");

        Transport tr = mailSession.getTransport();
        tr.connect(null,"123");
        tr.sendMessage(message, message.getAllRecipients());
        tr.close();
    }
}
