package com.example.questions;

import java.util.ArrayList;
import java.util.List;

public class Missing_Words {

    public static void main(String[] args) {


        missingWords("Hello how are you", "how are");

    }

    public static String[] missingWords(String s, String string) {

        String[] sArr = s.split("\\s");
        String[] tArr = string.split("\\s");


        String[] missingWords = new String[sArr.length - tArr.length];

        int j = 0;
        for (int i = 0; i < sArr.length; i++) {

            int flag = 0;
            for (int i1 = 0; i1 < tArr.length; i1++) {

                if (sArr[i].equals(tArr[i1])) {

                    flag = 1;
                    tArr[i1] = "";
                    break;
                }
            }
            if (flag == 0) {

                missingWords[j] = sArr[i];
                System.out.println(missingWords[j]);

                j++;
            }
        }


        return missingWords;
    }
}
