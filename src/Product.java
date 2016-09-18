import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ravinderk on 6/28/2016.
 */
public class Product {

    private static boolean isProduct(List<Integer> a, int n, int p){
        Collections.sort(a);
        for (int i =0 ; i < a.size() ; i++) {
            int num = a.get(i);
            if(num != 0 && p%num == 0) {
                Integer index = Collections.binarySearch(a.subList(i+1, a.size()), p/num);
                if (index >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main (String[] args) {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        List<Integer> a = new ArrayList<Integer>();
        // One by one run for all input test cases
        while (t > 0)
        {
            a.clear();
            int n = sc.nextInt();
            int p = sc.nextInt();
            for(int i =0 ; i < n ; i++) {
                a.add(sc.nextInt());
            }

            System.out.println(isProduct(a,n,p) ? "Yes": "No");

            t--;
        }
    }
}
