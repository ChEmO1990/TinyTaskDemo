package com.chemo.hdz.tinytaskdemo.util;

/**
 * Created by chemo1990 on 29/04/17.
 */

public class WordUtilities {
    public static String getInitialLetters(String input){
        StringBuilder sb = new StringBuilder();
        for(String s : input.split(" ")) {
            sb.append(s.charAt(0));
        }
        return sb.toString().substring(0, 2);
    }
}
