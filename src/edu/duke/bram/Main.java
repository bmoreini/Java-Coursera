
public class Main {

    public void main(String[] args) {
        int key = 17;
        edu.duke.FileResource fr = new edu.duke.FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message,key);
        System.out.println( encrypted );
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println( decrypted );
    }
}
