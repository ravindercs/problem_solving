import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ravinderk on 6/28/2016.
 */
public class Handshake {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            System.out.println(findHandshakeCount(n));

            t--;
        }
    }

    private static int findHandshakeCount(int n) {
        if(n < 2 ) return 0;
        return  n + n - 3;
    }

}
