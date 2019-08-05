package com.bram;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bram.CaesarCipher;
import edu.duke.FileResource;

public class CaesarBreaker {
	
	public static void main(String[] args) {
		String msg="Dudqx! Atsn";
        System.out.print(decryptMsg(msg)+"\n");
        System.out.print(decrypt(msg,3));
	}

	/**
     * Method for decrypting msg, encrypted with one key.
     * @param   encrypted string to be decrypted
     * @return  decrypted msg with key guessed
     */
	
	public static String decryptMsg(String encrypted) {
		countLetters(encrypted);
		int key = findKey(maxIndex(freqs));
		StringBuilder sb = new StringBuilder(encrypted);
		for (int i=0;i<sb.length();i++) {
			sb.setCharAt(i, decryptChar(encrypted.charAt(i),key));
		}
		System.out.println("Derypted Message: " + sb.toString());
		return sb.toString();
	}
	
	 /**
    * Count occurrences of letters in string.
    * @param   msg String for which number of letters is to be calculated
    * @return  int array containing frequency of letters
    */

	public static int[] countLetters(String msg) {
		for (int i=0;i<msg.length();i++) {
			for (int j=0;j<26;j++) {
				if (msg.charAt(i)==alphabet.charAt(j)) {
					freqs[j]++;
					// System.out.print(msg.charAt(i));
				}
			}
		}
		/* DEBUGGER */
		System.out.println("countLetters :" + Arrays.toString(freqs));
		return freqs; 
	}
	
    /**
     * Find index of max value in array.
     * @param   vals array of ints to be checked.
     * @return  index of max value in ints array
     */
	public static int maxIndex(int[] freqs) {
		int maxVal = 0;
		int maxValIndex=0;
		for (int j=0;j<26;j++) {
			if (freqs[j]>maxVal){
				maxVal=freqs[j];
				maxValIndex=j;
			}
		}
		System.out.print("4 is now at "+maxValIndex+"\n");
		return maxValIndex; 
	}
	
	
	
    /**
     * Method for finding encryption key, based on most common occurrences of letter
     * in encrypted msg, assuming that it represents 'e';
     * @param   msg encrypted string for which key is to be found
     * @return  encryption key for msg
     */
	public static int findKey(int maxValIndex) {
		int key = 0;
		if (maxValIndex>4) {
			key = maxValIndex+4; 
			// working with left shift
		}
		else if (maxValIndex<4) {
			key = 26-maxValIndex+2;
			// working with right shift
		}
		else key=0;
		// working with no shift
		System.out.println("Key is "+key);
		return key; 
	}
	
	/**
	 * Helper function for decrypting single character with key. 
	 * Decrypts letters only, returning non letters as is.
	 * @param   ch  character to be decrypted
	 * @param   key to be used in decrypting
	 * @return  uppercase or lowercase decrypted character
	 */
	
	public static char decryptChar(char ch, int key) {
		String shiftedLower = alphabet.substring(key) + alphabet.substring(0, key);
		String shiftedUpper = ALPHABET.substring(key) + ALPHABET.substring(0, key);
		String chStLow=String.valueOf(ch).toLowerCase();
		int genIndex = shiftedLower.indexOf(chStLow);
		if (genIndex > -1){
			if (Character.isUpperCase(ch)) {
				return shiftedUpper.charAt(genIndex);
			}
			else return shiftedLower.charAt(genIndex);
		}
		else return ch;
	}
	
    /**
     * Decrypt Caesar Cipher with a given key.
     * @param   encrypted String to be decrypted
     * @param   key key for decrypting.
     * @return  decrypted msg
     */
	
		public static String decrypt(String encrypted, int key) {
		String message = CaesarCipher.encrypt(encrypted, 26-key);
		return message;
	}

	

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
	 
	 private String decryptTwoKeys(String asString) {
		// TODO Auto-generated method stub
		return null;
	}

	
	private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static int[] freqs = new int[26]; 
}
