import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class FindSortedCount {
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
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            findFrequency(a,0,n-1,map);
            printMap(map);
            t--;
        }
    }

    private static void printMap(Map<Integer, Integer> map) {
        for (Integer i : map.keySet()) {
            System.out.println("Element "+i+" occurs "+map.get(i)+" times");
        }
    }

    private static void findFrequency(int[] a, int start, int end, Map<Integer, Integer> map) {
        if(a[start] == a[end]) {
            int f = end - start + 1;
            Integer old = map.get(a[start]);
            if(old != null) {
                f += old;
            }
            map.put(a[start],f);
        } else {
            int m = (start + end)/2;
            findFrequency(a, start, m, map);
            findFrequency(a, m+1, end, map);
        }
    }
}
