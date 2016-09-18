import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by ravinderk on 6/28/2016.
 */
public class KLargest {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] a = new int[1000];
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            for(int i = 0 ; i < n ; i++) {
                a[i] = sc.nextInt();
            }

            PriorityQueue<Integer> kLargest = getKLargest(a, n, k);
            List<Integer> arr = new ArrayList<Integer>();
            for (int i = 0 ; i  < k ; i++) {
                arr.add(kLargest.remove());
            }
            for (int i = k -1 ; i >= 0 ; i--) {
                System.out.print(arr.get(i)+" ");
            }
            System.out.println();

            t--;
        }
    }

    private static PriorityQueue<Integer> getKLargest(int[] a, int n, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (int i = 0 ; i < k ; i++) {
            q.add(a[i]);
        }

        for (int i = k ; i < n ; i++) {
            if(a[i] > q.element()) {
               q.remove();
                q.add(a[i]);
            }
        }

        return q;
    }
}
