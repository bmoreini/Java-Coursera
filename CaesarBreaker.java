package com.bram;
import java.util.Arrays;
import com.bram.CaesarCipher;
import edu.duke.FileResource;

public class CaesarBreaker {
	
	public static void main(String[] args) {
		String decrypt = "every auto";
		freqs = countLetters(decrypt);
		int mkey = findKey(maxIndex(freqs));
        System.out.print(CaesarCipher.encrypt(decrypt,mkey));
    }
	
	 /**
     * Count occurrences of letters in string.
     * @param   msg String for which number of letters is to be calculated
     * @return  int array containing frequency of letters
     */
	// finds the right letters 
	public static int[] countLetters(String msg) {
		for (int i=0;i<msg.length();i++) {
			for (int j=0;j<26;j++) {
				if (msg.charAt(i)==alphabet.charAt(j)) {
					freqs[j]++;
					// System.out.print(msg.charAt(i));
				}
			}
		}
		return freqs; 
	}
	
    /**
     * Find index of max value in array.
     * @param   vals array of ints to be checked.
     * @return  index of max value in ints array
     */
	// returns most frequent letter position in array
	public static int maxIndex(int[] freqs) {
		int maxVal = 0;
		int maxValIndex=0;
		for (int j=0;j<26;j++) {
			if (freqs[j]>maxVal){
				maxVal=freqs[j];
				maxValIndex=j;
			}
		}
		// System.out.print("4 is now at "+maxValIndex);
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
			key = 26-maxValIndex+4; 
			// working with left shift
		}
		else if (maxValIndex<4) {
			key = 4-maxValIndex;
			// working with right shift
		}
		else key=0;
		// working with no shift
		return key; 
	}
	
    /**
     * Decrypt Caesar Cipher with a given key.
     * @param   encrypted String to be decrypted
     * @param   key key for decrypting.
     * @return  decrypted msg
     */
	public static String decrypt(String encrypted, int key) {
		CaesarCipher cc = new CaesarCipher();
		String message = CaesarCipher.encrypt(encrypted, 26 - key);
		return message;
	}
	
	
    /**
     * Helper function for decrypting single character with key. 
     * Decrypts letters only, returning non letters as is.
     * @param   ch  character to be decrypted
     * @param   key to be used in decrypting
     * @return  uppercase or lowercase decrypted character
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
	 
	 private String decryptTwoKeys(String asString) {
		// TODO Auto-generated method stub
		return null;
	}

	
	private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private static int[] freqs = new int[26]; 
}
