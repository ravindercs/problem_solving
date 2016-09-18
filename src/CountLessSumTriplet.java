import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class CountLessSumTriplet {
    public static void main(String[] arr) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int sum = sc.nextInt();
            List<Integer> a = new ArrayList<Integer>(n);
            for (int i = 0; i < n; i++) {
                a.add(sc.nextInt());
            }
            System.out.println(countTriplet(a, n, sum));
            t--;
        }
    }

    private static int countTriplet(List<Integer> a, int n, int sum) {
        Collections.sort(a);
        int count = 0;
        for (int i = 0 ; i < n-2 ; i++) {
            int j = i+1;
            int k = n-1;
            while (j<k) {
                if(a.get(i) + a.get(j) + a.get(k) >= sum) {
                    k--;
                } else {
                    count =+ k-j;
                    j++;
                }
            }
        }

        return count;
    }
}
