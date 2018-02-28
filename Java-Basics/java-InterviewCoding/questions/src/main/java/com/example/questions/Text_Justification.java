package com.example.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: singh on: 27-Feb-18.
 */

public class Text_Justification {

    public static void main(String[] args) {


        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};

        fullJustify(words, 10);
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {

        List<String> resultList = new ArrayList<>();
        int spaceCount = 0;
        int wordCount = 0;
        int widthLeft = maxWidth;
        String currentLine= "";
        String spacer = " ";

        int lineSize = 0;
        for (String word : words) {

            lineSize = currentLine.length() + spacer.length() + word.length();
            if ((lineSize <= maxWidth)) {
                currentLine += word + spacer;
            } else {
                resultList.add(currentLine);
                System.out.println(currentLine);

                currentLine = word;
                lineSize = 0;
            }


        }
        return resultList;



    }


}
