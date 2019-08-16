package com.bram;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;
import java.util.List;

import com.bram.CaesarCipher;
import edu.duke.FileResource;

public class CaesarBreaker {
	
	public static void main(String[] args) {
		System.out.print(stringMerge("ACE", "BDF"));
		String msg="Dudqx! Ztsn";
		System.out.println("Derypted Message: "+decryptMsg(msg,1)+"\n");
	}

	/**
     * Method for decrypting msg, encrypted with one key.
     * @param   encrypted string to be decrypted
     * @return  decrypted msg with key guessed
     */
	
	public static String decryptMsg(String encrypted, int keyNum) {
		int[] freqs = new int[26];
		countLetters(encrypted, freqs);
		int key = findKey(maxIndex(freqs), keyNum);
		StringBuilder sb = new StringBuilder(encrypted);
		for (int i=0;i<sb.length();i++) {
			sb.setCharAt(i, decryptChar(encrypted.charAt(i),key));
		}
		return sb.toString();
	}
	
	 /**
    * Count occurrences of letters in string.
    * @param   msg String for which number of letters is to be calculated
    * @return  int array containing frequency of letters
    */

	public static int[] countLetters(String msg, int[] freqs) {
		for (int i=0;i<msg.length();i++) {
			for (int j=0;j<26;j++) {
				if (msg.charAt(i)==alphabet.charAt(j)) {
					freqs[j]++;
					// System.out.print(msg.charAt(i));
				}
			}
		}
		/* DEBUGGER */
		// System.out.println("countLetters :" + Arrays.toString(freqs));
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
		/* DEBUGGER */
		// System.out.print("4 is now at "+maxValIndex+"\n");
		return maxValIndex; 
	}
	
	
	
    /**
     * Method for finding encryption key, based on most common occurrences of letter
     * in encrypted msg, assuming that it represents 'e';
     * @param   msg encrypted string for which key is to be found
     * @return  encryption key for msg
     */
	public static int findKey(int maxValIndex, int keyNum) {
		int key = 0;
		if (maxValIndex<4) {
			key = 4-maxValIndex; 
		}
		else if (maxValIndex>4) {
			key = 26-maxValIndex;
		}
		else key=0;
		/* DEBUGGER */
		System.out.println("Key "+keyNum+ " is "+key);
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
		int genIndex = alphabet.indexOf(chStLow);
		if (genIndex > -1){
			if (Character.isUpperCase(ch)) {
				return shiftedUpper.charAt(genIndex);
			}
			else return shiftedLower.charAt(genIndex);
		}
		else return ch;
	}
	
    /**
     * Decrypt using CaesarCipher with a given key.
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
	
	public static String stringSplit(String encrypted, int start) {
		StringBuilder sb = new StringBuilder(encrypted);
		for (int i=start+1;i<encrypted.length()-2;i++) {
			sb.delete(i,i+1);
		}
		System.out.print(sb.toString());
		// halfOfString
		return sb.toString();
	}
	
	
    /**
     * Helper function for merging string split with halfOfString
     * @param   s0  substring starting from index 0
     * @param   s1  substring starting from index 1
     * @return  original string split with halfOfString
     */
	
	public static String stringMerge(String s0, String s1) {
		String merged = "";
		StringBuilder sbm = new StringBuilder(merged);
		for (int i=0;i<s0.length()+s1.length();i++) {
			if (i==0)sbm.append(s0.charAt(0));
			else if (i%2==0) sbm.append(s0.charAt(i/2));
			else sbm.append(s1.charAt(Math.round(i/2)));
		}
		return sbm.toString();
	}
	
    /**
     * This method attempts to determine the two keys used to encrypt the message,
     * prints the two keys, and then returns the decrypted String with those two keys.
     * @param   encrypted   string encrypted with encryptTwoKeys
     * @return  decrypted string
     */

	public static String decryptMsgTwoKeys(String encrypted) {
		String stringKey1=stringSplit(encrypted, 0);
		String stringKey2=stringSplit(encrypted, 1);
		return stringMerge(decryptMsg(stringKey1,1),decryptMsg(stringKey2,2));
	}
	
	
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
}
