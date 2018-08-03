package javalesson.logger;

import java.io.InputStream;
import java.util.logging.*;

public class LogDemo {
    private static final Logger LOGGER = Logger.getLogger(LogDemo.class.getName());

    public static void main(String[] args) {
        System.out.println(LOGGER.getName());
        LOGGER.log(Level.INFO, "I’m logging ");
        // SEVERE , WARNING , INFO ,
        // CONFIG , FINE , FINER , FINEST
        LOGGER.warning("We have a problem !");

        int x = 5, y = 6, e = 9;
        LOGGER.log(Level.FINEST,
                " Current value of x is " + x);
        LOGGER.log(Level.FINEST,
                " Current value of x is {0}", x);
        LOGGER.log(Level.FINEST,
                " Point coordinates are ({0} , {1}) ",
                new Object[]{x, y});
        LOGGER.log(Level.SEVERE,
                " Unexpected exception ", e);
        try (InputStream inputStream =
                     LogDemo.class.getResourceAsStream("LogDemo.class")) {
            int read = inputStream.read();
            while (read >= 0) {
                System.out.printf("%02 x", read);
                read = inputStream.read();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

