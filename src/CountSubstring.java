import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class CountSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            System.out.println(countSubstring(s));
            t--;
        }
    }
    //1=>0
    //101 =>1
    //0101010 => 3
    //1111 = 12
    private static int countSubstring(String s) {
        int len = s.length();
        int ones = 0;
        for (int i = 0 ; i < len; i++) {
            if(s.charAt(i) == '1') {
                ones++;
            }
        }

        return ones*(ones - 1)/2;
    }
}