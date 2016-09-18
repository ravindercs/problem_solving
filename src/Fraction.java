import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by ravinderk on 6/29/2016.
 */
public class Fraction {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int d = sc.nextInt();
            double f = n/(double)d;
            int num = (int)f;
            f = f - num;
            Set<Integer> fSet = new LinkedHashSet<Integer>();
            int digit = 0;
            int count = 0;
            while (f > 0) {
                f *= 10;
                digit = (int)f;
                fSet.add(digit);
                f -= digit;
                count++;
            }
            System.out.print(num+".");
            if(count == fSet.size()) {
                for (Integer i : fSet) {
                    System.out.print(i);
                }
            } else {
                System.out.print("(");
                for (Integer i : fSet) {
                    System.out.print(i);
                }
                System.out.print(")");
            }
            System.out.println();
            t--;
        }
    }
}
