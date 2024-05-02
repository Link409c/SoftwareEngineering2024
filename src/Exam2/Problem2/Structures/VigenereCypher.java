package Exam2.Problem2.Structures;

/**
 * Class modeling encryption using the Vigenere Cypher algorithm.
 */
public class VigenereCypher {

    private String encrypt(String aString){
        //create key
        String key = createKey(new StringBuilder(aString), aString.length());
        //for each letter of each word,
        if(key.length() != aString.length()){
            throw new IllegalArgumentException("Key and Text lengths do not match.");
        }else {
            for (int i = 0; i < aString.length(); i++) {
                //convert string character to number
                //convert key character to number
                //add character and key
                //mod 26
                //set the value as this index of the string
            }
        }
        return aString;
    }

    private String decrypt(String aString){
        //create key
        String key = createKey(new StringBuilder(aString), aString.length());
        //for each letter of each word,
        if(key.length() != aString.length()){
            throw new IllegalArgumentException("Key and Text lengths do not match.");
        }else {
            for (int i = 0; i < aString.length(); i++) {
                //convert string character to number
                //convert key character to number
                //subtract key from character
                //mod 26
                //set the value as this index of the string
            }
        }
        return aString;
    }

    private String makeKey(StringBuilder stb, int length){
        int numCycles = length / getKey().length() - 1;
        int remaining = length % getKey().length();
        //add the key word to the string for x amount of cycles
        for(int i = 0; i < numCycles; i++){
            for(int j = 0; j < getKey().length(); j++){
                stb.append(getKey().charAt(j));
            }
        }
        //add the remaining characters to the string to reach the limit
        for(int i = 0; i < remaining; i++){
            stb.append(getKey().charAt(i));
        }
        //key and string should be same length
        return stb.toString();
    }

    public String encryptString(String aString){
        return encrypt(aString);
    }

    public String decryptString(String aString){
        return decrypt(aString);
    }

    public String createKey(StringBuilder stb, int messageLength){
        return makeKey(stb, messageLength);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private String key;
}
