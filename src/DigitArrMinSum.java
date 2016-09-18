import java.util.*;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class DigitArrMinSum {
    public static void main(String[] arr) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            List<Integer> a = new ArrayList<Integer>(n);
            for (int i = 0; i < n; i++) {
                a.add(sc.nextInt());
            }
            System.out.println(findMinSum(a));
            t--;
        }
    }

    private static int findMinSum(List<Integer> a) {
        Collections.sort(a);
        int n = a.size();
        int first = 0 ;
        int second = 0;
        for (int i = 0 ; i < n; i++) {
            if(i%2 == 0) {
                first = first * 10 + a.get(i);
            } else {
                second = second*10 + a.get(i);
            }
        }
        System.out.println("first : "+first + " second : "+second);
        return first + second;
    }
}
