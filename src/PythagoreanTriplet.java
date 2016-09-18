import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class PythagoreanTriplet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            System.out.println(findTriplet(arr, n));
            t--;
        }
    }

    private static boolean findTriplet(ArrayList<Integer> arr, int n) {
        //Square the arr
        for (int i = 0 ; i < n ; i ++) {
            arr.set(i, arr.get(i)*arr.get(i));
        }
        Collections.sort(arr); //nlogn

        for (int k = n-1; k >1 ; k--) {
            for (int i = 0, j = k-1 ; i < j ;) {
                int sum = arr.get(i) + arr.get(j);
                if(sum == arr.get(k)) {
                    return true;
                } else if(sum < arr.get(k)) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return false;
    }
}
