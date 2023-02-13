package com.example.armanhw1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Helper {

    private static final HashMap<Integer, String> hashMap = new HashMap<>();

    static {
        hashMap.put(0, "");
        hashMap.put(1, "one");
        hashMap.put(2, "two");
        hashMap.put(3, "three");
        hashMap.put(4, "four");
        hashMap.put(5, "five");
        hashMap.put(6, "six");
        hashMap.put(7, "seven");
        hashMap.put(8, "eight");
        hashMap.put(9, "nine");
        hashMap.put(10, "ten");
        hashMap.put(11, "eleven");
        hashMap.put(12, "twelve");
        hashMap.put(13, "thirteen");
        hashMap.put(14, "fourteen");
        hashMap.put(15, "fifteen");
        hashMap.put(16, "sixteen");
        hashMap.put(17, "seventeen");
        hashMap.put(18, "eighteen");
        hashMap.put(19, "nineteen");
        hashMap.put(20, "twenty");
        hashMap.put(30, "thirty");
        hashMap.put(40, "forty");
        hashMap.put(50, "fifty");
        hashMap.put(60, "sixty");
        hashMap.put(70, "seventy");
        hashMap.put(80, "eighty");
        hashMap.put(90, "ninety");
    }

    public static String integerToEnglish(String number) {

        if (!number.matches("^(?:(?:\\-{1})?\\d+(?:\\.{1}\\d+)?)$")) {
            return "Not a number!";
        }


        if (Integer.parseInt(number) != 0) {
            number = number.replaceFirst("^0*", "");
        }

        int num = Integer.parseInt(number);

        if (num == 0) {
            return "zero";
        }

        if (num < 0) {
            return "negative " + integerToEnglish(String.valueOf(Math.abs(num)));
        }

        StringBuilder result = new StringBuilder();
        ArrayList<String> units = new ArrayList<>(Arrays.asList("", "thousand", "million"));
        int i = 0;
        while (num > 0) {
            if (num % 1000 != 0) {
                result.insert(0, integerToEnglishLessThanAThousand(num % 1000) + " " + units.get(i) + " ");
            }
            num = num / 1000;
            i++;
        }
        return result.toString().trim();
    }

    private static String integerToEnglishLessThanAThousand(int number) {
        String result = "";
        if (hashMap.containsKey(number)) {
            return hashMap.get(number);
        }

        if (number >= 100) {
            result = result + hashMap.get(number / 100) + " hundred ";
            number = number % 100;
        }
        if (number > 0) {
            if (!result.isEmpty()) {
                result = result + "and ";
            }
            if (number < 20) {
                result = result + hashMap.get(number);
            } else {
                result = result + hashMap.get(number - number % 10) + " " + hashMap.get(number % 10);
            }
        }

        return result.trim();
    }
}
