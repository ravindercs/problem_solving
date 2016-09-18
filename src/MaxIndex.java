import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by ravinderk on 6/28/2016.
 */
public class MaxIndex {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] a = new int[1000];
        while (t > 0)
        {
            int n = sc.nextInt();
            for(int i = 0 ; i < n ; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(getMaxIndex(a,n));
            t--;
        }
    }

    private static int getMaxIndex(int[] a, int n) {
        int maxIndex = 0;
        for(int i = 0; i < n ; i++ ) {
            for(int j = n-1 ; j > i ; j--) {
                if(a[i] < a[j] && maxIndex < j-i) {
                    maxIndex = j - i;
                    break;
                }
            }
        }

        return maxIndex;
    }
}
