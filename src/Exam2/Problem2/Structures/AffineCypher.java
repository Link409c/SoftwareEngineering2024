package Exam2.Problem2.Structures;

/**
 * Class modeling encryption using the Affine Cypher algorithm.
 */
public class AffineCypher {

    private String encrypt(String aString){
        //convert string to number
        int stringNum = aString.hashCode();
        //encrypt
        return String.valueOf((getA() * stringNum + getB()) % 26);
    }

    private String decrypt(String aString){
        int stringNum = Integer.parseInt(aString);
        //check that inverse of a mod 26 exists
        if(gcdByEuclidsAlgorithm(getA(), 26) == 1){
            //if it does, proceed with decryption
            return String.valueOf(Math.pow(getA(), -1) * (stringNum - getB()) % 26);
        }
        else{
            return "Cannot decrypt.";
        }
    }

    public String encryptString(String aString){
        return encrypt(aString);
    }

    public String decryptString(String aString){
        return decrypt(aString);
    }

    /**
     * GCD Method. Referenced from Baeldung.com/java-greatest-common-divisor
     * @param n1 the divisee
     * @param n2 the divisor
     * @return recursively calculates n1 mod n2 until no further division can be done.
     */
    public int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }

    public AffineCypher(int a, int b){
        setA(a);
        setB(b);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    private int a;
    private int b;
}
