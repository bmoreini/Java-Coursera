import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import edu.duke.FileResource;

/* Coursera Caesar Cipher
 * 
 */
public class WordLengths {
	
	public static void countWordLengths(FileResource resource, int[] counts){		
		for(String word : resource.words()){
			int indexCount = word.length();
			if (counts[indexCount]<1){
				counts[indexCount]=1;
			}
			else {
				counts[indexCount]++;
			}
		}
	}
	
	public static void main(String[] args) {
		FileResource resource= new FileResource("data/words/smallHamlet.txt");
		countWordLengths(resource,counts);
		System.out.println(Arrays.toString(counts));
	}	
	
	private static int[] counts = new int[30];
}


