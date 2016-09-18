import java.util.*;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class SumSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0 ; i < n ; i++){
                a[i] = sc.nextInt();
            }
            findSumSubArray(a,n);
            t--;
        }
    }

    private static void findSumSubArray(int[] a, int n) {
        int s = 0;
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>(n);
        for(int i = 0; i < n; i++) {
            s += a[i];
            if(s == 0) {
                System.out.println("Sub Array : 0 - "+i);
            }
            if(map.containsKey(s)) {
                for (Integer j : map.get(s)) {
                    System.out.println("Sub Array : " + (j + 1) + " - " + i);
                }
            }
            if(map.get(s) == null) {
                map.put(s, new ArrayList<Integer>());
            }
            map.get(s).add(i);
        }
    }

}
