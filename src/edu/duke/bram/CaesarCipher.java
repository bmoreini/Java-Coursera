package com.bram;
import java.util.ArrayList;
import java.util.List;


public class CaesarCipher {

    public static String encrypt(String input, int key) {
        StringBuilder encrypted = new StringBuilder(input);
        checkUppers(encrypted);
        String lowerEncrypted = String.valueOf(encrypted).toLowerCase();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        for(int i = 0; i < lowerEncrypted.length(); ++i) {
            char curChar = lowerEncrypted.charAt(i);
            int idx = alphabet.indexOf(curChar);
            if (idx != -1) {
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(i, newChar);
            }
        }
        return toUpper(encrypted).toString();
    }

    public static StringBuilder toUpper(StringBuilder encrypted){
        for(int i = 0; i < encrypted.length(); ++i) {
            for (int num : uppers) {
                if (i == num) {
                    encrypted.setCharAt(i, Character.toUpperCase(encrypted.charAt(i)));
                }
            }
        }
        return encrypted;
    }

    public static void checkUppers(StringBuilder encrypted) {
        for (int i=0;i<encrypted.length();i++){
            if (Character.isUpperCase(encrypted.charAt(i))) {
                uppers.add(i);
            }
        }
    }

    private static List<Integer> uppers = new ArrayList<>();

}
