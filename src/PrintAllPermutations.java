/**
 * Created by ravinderk on 8/1/2016.
 */
public class PrintAllPermutations {
    public static void main(String[] args) {
        printPermutations("RAVI".toCharArray());
    }

    private static void printPermutations(char[] s) {
        printPermutations(s,0);
    }

    private static void printPermutations(char[] s, int i) {
        if(i == s.length) {//Success
            System.out.println(s);
        }

        for (int k = i ; k < s.length; k++) {
            //Generate next state
            char t = s[i];
            s[i] = s[k];
            s[k] = t;
            //Check for success
            printPermutations(s, i+1);
            //Backtrack
            t = s[i];
            s[i] = s[k];
            s[k] = t;
        }
    }
}
