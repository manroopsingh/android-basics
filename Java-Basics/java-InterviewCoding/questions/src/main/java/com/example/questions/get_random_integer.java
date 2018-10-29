package com.example.questions;

import java.util.Random;

public class get_random_integer {

    public static void main(String[] args) {

//        System.out.println(getRandom(27));

//        System.out.println(solution("a"));

        System.out.println(sendMessages("SMS messages are really short", 12));

    }

    public static long getRandom(int n) {

        int max = (int) Math.pow(10, 8);

        long value = new Random().nextInt(max - n + 1) + n;

        return value * 10;

    }

    public static String solution(String s) {

        char ch = s.charAt(0);

        if (ch > 70) {
            return "something";
        }
        return "other";
    }

    public static int sendMessages(String s, int k) {

        StringBuilder sms = new StringBuilder();
        int smsCount = 0;
        int msgLength = 0;
        int wordLength = 0;

        String[] message = s.split(" ");

        for (String s1 : message) {
            System.out.println(s1
            );
        }

        int i = 0;
        while (i<message.length) {

            wordLength = message[i].length();
            if (msgLength + wordLength < k) {
                sms.append(message[i] +" ");
                msgLength += wordLength;
                msgLength += 1;
                i++;

            } else {
                System.out.println(sms.toString());
                sms.setLength(0);
                msgLength = 0;
                smsCount++;
            }


        }
        if (smsCount > 0) {
            return smsCount;
        } else return -1;


    }
}
