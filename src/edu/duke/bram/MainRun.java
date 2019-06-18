package com.bram;

import edu.duke.FileResource;

public class MainRun {
    public static void main(String[] args) {
        int key = 3;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = CaesarCipher.encrypt(message,key);
        System.out.println( encrypted );
        String decrypted = CaesarCipher.encrypt(encrypted, 26-key);
        System.out.println( decrypted );
    }
}
