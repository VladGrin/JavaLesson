package javalesson.basic;

import java.text.MessageFormat;
import java.util.GregorianCalendar;

public class StringFormat {
    public static void main(String[] args) {
        String s1 = "On 22.02.2017 was rain";
        String s2 = "On 23.02.2017 was sunny";
        String s3 = "On {0, date, full} was {1}, {2, number, currency} buildings was destroed. ";
        s3 = "On {0, date, full} was {1}, {2, choice, 0#no houses|1#one house|2#{2} houses} buildings was destroed. ";
        String s4 = MessageFormat.format(s3, new GregorianCalendar(2018, 10, 10).getTime(), "cold", 0);

        System.out.println(s4);

        // number,  time, date, choice
        // integer, currency, percent
        // short, medium, long, full
    }
}
