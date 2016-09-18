 import java.util.Scanner;

/**
 * Created by ravinderk on 6/29/2016.
 */
public class MinDiffSubset {
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
            int sumTotal = 0;
            for(int i = 0 ; i < n ; i++) {
                sumTotal += a[i];
            }
            System.out.println(findMinDiff(a,n, 0, sumTotal));
            t--;
        }
    }

    private static int findMinDiff(int[] a, int n, int sum, int sumTotal) {
        if(n == 0) {
            return Math.abs((sumTotal-sum) - sum);
        }

        return Math.min(findMinDiff(a, n-1, sum+ a[n-1], sumTotal), findMinDiff(a, n-1, sum, sumTotal));
    }
}
