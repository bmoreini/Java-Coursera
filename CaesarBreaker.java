package com.bram;

import edu.duke.FileResource;

public class CaesarBreaker {
	
	 /**
     * Count occurrences of letters in string.
     * @param   msg String for which number of letters is to be calculated
     * @return  int array containing frequency of letters
     */
	public static void countLetters(String msg) {
		for (int i=0;i<msg.length();i++) {
			for (int j=0;j<26;j++) {
				if (string[i]===)
			}
		}
	}
	
    /**
     * Find index of max value in array.
     * @param   vals array of ints to be checked.
     * @return  index of max value in ints array
     */
	public static void maxIndex() {}
	
    /**
     * Decrypt Caesar Cipher with a given key.
     * @param   encrypted String to be decrypted
     * @param   key key for decrypting.
     * @return  decrypted msg
     */
	public String decrypt(String encrypted, int key) {
		CaesarCipher cc = new CaesarCipher();
		String message = cc.encrypt(encrypted, 26 - key);
	}
	
	
    /**
     * Helper function for decrypting single character with key. 
     * Decrypts letters only, returning non letters as is.
     * @param   ch  character to be decrypted
     * @param   key to be used in decrypting
     * @return  uppercase or lowercase decrypted character
     */
	
    /**
     * Method for finding encryption key, based on most common occurrences of letter
     * in encrypted msg, assuming that it represents 'e';
     * @param   msg encrypted string for which key is to be found
     * @return  encryption key for msg
     */
	
    /**
     * Method for decrypting meg, encrypted with one key.
     * @param   encrypted string to be decrypted
     * @return  decrypted msg with key guessed
     */
	
    /**
     * This method should return a new String that is every 
     * other character from message starting with the start position.
     * @param message   string to be split in half
     * @param   start   starting point to begin splitting
     * @return  string containing every other letter from input
     */
	
    /**
     * Helper function for merging string split with halfOfString
     * @param   s0  substring starting from index 0
     * @param   s1  substring starting from index 1
     * @return  original string split with halfOfString
     */
	
    /**
     * This method attempts to determine the two keys used to encrypt the message,
     * prints the two keys, and then returns the decrypted String with those two keys.
     * @param   encrypted   string encrypted with encryptTwoKeys
     * @return  decrypted string
     */
	
    /**
     * Decrypt text encrypted with two keys.
     * @param   encrypted   text to be decrypted
     * @param   key0    first encryption key
     * @param   key1    second encryption key
     * @return  string decrypted using provided keys
     */
	
	 public String decryptFileTwoKeys() {
        FileResource fr = new FileResource();
        return decryptTwoKeys(fr.asString());
	 }
	 
	 private static int[] freqs = new int[26];
	 private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
}
