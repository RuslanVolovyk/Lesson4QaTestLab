package myTest.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Администратор on 17.03.2018.
 */
public class Utils {

    private final static String words = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
    private static String quantity;
    private static String price;
    private static StringBuilder builder;

    public static String getName() {

        return String.valueOf(builder);
    }

    public static String getQuantity() {
        return quantity;
    }

    public static String getPrice() {
        return price;
    }

    //generate random int data
    public static String randomIntData(int from, int to) {
        int value;
        value = (int) (from + Math.round((Math.random() * (to - from))));
        return quantity = convertFromIntToString(value);
    }

    //generate random float data
    public static String randomFloatData(float from, float to) {
        float value;
        value = (float) (from + (Math.random() * (to - from)));
        price = String.format("%.6f", value);

        return price;
    }

    private static String convertFromIntToString(int convert) {
        return "" + convert;
    }

    //generate random name
    public static String randomStringName() {
        Set<String> identifiers = new HashSet<>();
        Random rand = new Random();
        builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(words.charAt(rand.nextInt(words.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }
}
