package com.example.questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Missing_Words {

    public static void main(String[] args) {


        System.out.println(missingWordsOptimized("Hello how are you", "how are"));

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

    public static List<String> missingWordsOptimized(String s, String t) {

        List<String> missingWords = new ArrayList<>();
        String[] sArr = s.split("\\s");
        String[] tArr = t.split("\\s");

        int tIndex = 0;
        int sIndex = 0;
        while(tIndex<tArr.length){

            if(tArr[tIndex].equals(sArr[sIndex])){
                tIndex++;
                sIndex++;
            }else{
                missingWords.add(sArr[sIndex]);
                sIndex++;
            }

        }

        for(int i= sIndex;i<sArr.length;i++){
            missingWords.add(sArr[i]);
        }
        return missingWords;


    }
}
