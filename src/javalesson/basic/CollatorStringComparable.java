package javalesson.basic;

import javafx.print.Collation;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollatorStringComparable {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("vv");
        list.add("aa");
        list.add("dd");
        list.add("gg");
        list.add("bb");
        list.add("AA");
        list.add("ğğ");

        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.PRIMARY); // g = ğ, G = g
//        collator.setStrength(Collator.SECONDARY);  // ğ != g, G = g
//        collator.setStrength(Collator.TERTIARY);  // ğ != g, g != G
        Collections.sort(list, collator);
        list.stream().forEach(x-> System.out.println(x));
    }
}
