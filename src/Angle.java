import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ravinderk on 6/28/2016.
 */
public class Angle {
    public static void main (String[] args) {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        // One by one run for all input test cases
        while (t > 0)
        {
            int h = sc.nextInt();
            int m = sc.nextInt();

            int ma = m*6;
            int ha = h*60 + m/2;
            int angle = ma > ha ? (ma-ha) : (ha -ma);
            System.out.println(angle);

            t--;
        }
    }
}
