/**
 * Flips one bit of the given <code>value</code>.
 *
 * @param value     any number
 * @param bitIndex  index of the bit to flip, 1 <= bitIndex <= 32
 * @return new value with one bit flipped
 */
package javalesson.stepic;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

public class FlipBit {
    public static void main(String[] args) {
        System.out.println(flipBit(50, 7));
    }

    public static int flipBit(int value, int bitIndex) {
        int temp = value;
        temp = temp >> (bitIndex - 1);
        if (temp%2 == 0){
            value = value|(int)(Math.pow(2.0, (double) (bitIndex - 1)));
        } else {
            value = value^(int)(Math.pow(2.0, (double) (bitIndex - 1)));
        }
        return value;
    }
}

