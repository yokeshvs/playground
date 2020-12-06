package com.yo;

public class LineCount {
    public static void main(String[] args) {
        System.out.println(lineCount("abcd abce; amamamamam                     ", 10));
    }

    public static int lineCount(String s, int width) {
        if (s.length() == 0) return 0;
        int current = 0;
        int lineCount = 1;
        String[] words = s.split(" ");
        for(String word : words) {
            int wordLength = word.length();
            if(wordLength + current > width) lineCount++;
            if(wordLength + current > width) {
                current = wordLength;
            } else {
                current += wordLength;
            }
        }
        int spaceLength = 0;
        for(char c : s.toCharArray()) {
            if(c == ' ') spaceLength++;
        }

        int spaceLines = spaceLength / width;
        int spaceChar = spaceLength % width;
        if(current + spaceChar > width) lineCount++;
        lineCount += spaceLines;
        return lineCount;
    }
}
