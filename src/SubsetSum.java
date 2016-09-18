import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ravinderk on 8/1/2016.
 */
public class SubsetSum {
    public static void main(String[] args) {
        getSumSubset(new int[]{1,2,3,4}, 5);
        getSumSubset(new int[]{10, 7, 5, 18, 12, 20, 15}, 35);
        getSumSubset(new int[]{10, 7, 5, 18, 12, 20, 15}, 36);
    }

    private static void getSumSubset(int[] a, int k) {
        Queue<Integer> sol = new LinkedList<Integer>();
        if(getSumSubset(a, sol, k, 0)) {
            while (!sol.isEmpty()) {
                System.out.print(a[sol.remove()] + " ");
            }
            System.out.println();
        } else {
            System.out.println("Not Possible");
        }
    }

    private static boolean getSumSubset(int[] a, Queue<Integer> sol, int k, int sum) {
        if(sum == k) {
            return true;
        }

        for (int i = 0 ; i < a.length; i++) {
            if(!sol.contains(i)) {
                sum += a[i];
                sol.add(i);
                if(sum <= k && getSumSubset(a, sol, k, sum)) {
                    return true;
                }
                sum -= a[i];
                sol.remove(i);
            }
        }

        return false;
    }


}
