import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ravinderk on 6/28/2016.
 */
public class Tiles {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Character> number = new ArrayList<Character>();
        int t = sc.nextInt();

        while (t > 0)
        {
            int w = sc.nextInt();
            if(w == 1) {
                System.out.println(1);
                break;
            }
            if(w == 2) {
                System.out.println(2);
                break;
            }
            long x = 1;
            long y = 2;
            long z = 0;
            for(int i = 3; i <= w ; i++) {
                z = x + y;
                x = y;
                y = z;
            }

            System.out.println(z);

            t--;
        }
    }
}
