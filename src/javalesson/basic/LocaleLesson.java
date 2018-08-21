package javalesson.basic;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class LocaleLesson {
    public static void main(String[] args) {
        Locale locale = new Locale("en", "US");
        Locale locale1 = Locale.getDefault();
        Locale locale2 = Locale.GERMAN;
        locale2 = new Locale("de", "GR");
        Locale locale3 = new Locale("uk", "UA");

//        Locale[] locales = Locale.getAvailableLocales();
//        Arrays.stream(locales).forEach(x-> System.out.println(x));

        System.out.println(locale1);

        System.out.println(NumberFormat.getCurrencyInstance(locale).format(1000));
        System.out.println(NumberFormat.getCurrencyInstance(locale2).format(1000));
        System.out.println(NumberFormat.getCurrencyInstance(locale3).format(1000));

        System.out.println(DateFormat.getDateInstance(DateFormat.FULL, locale).format(new Date()));
        System.out.println(DateFormat.getDateInstance(DateFormat.FULL, locale2).format(new Date()));
        System.out.println(DateFormat.getDateInstance(DateFormat.FULL, locale3).format(new Date()));
    }
}
