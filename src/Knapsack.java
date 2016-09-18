import java.util.Scanner;

/**
 * Created by ravinderk on 6/29/2016.
 */
public class Knapsack {
    // 2 3 5 1 8 - 10
    private static long findKnapsack(int[] a, int v[], int n , int W ) {
        long k = 0;
        long[][] D = new long[n+1][W+1];

        for(int i = 0 ; i <= n ; i++) {
            for(int w = 0 ; w <= W ; w++) {
                if(i == 0 || w == 0) {
                    D[i][w] = 0;
                } else if(a[i-1] <= w) {
                    D[i][w] = Math.max(v[i-1]+ D[i-1][w-a[i-1]], D[i-1][w]);
                } else {
                    D[i][w] = D[i-1][w];
                }
            }
        }
        return D[n-1][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int W = sc.nextInt();
            int[] a = new int[n];
            int[] v = new int[n];
            for(int i = 0 ; i < n ; i++){
                a[i] = sc.nextInt();
            }
            for(int i = 0 ; i < n ; i++){
                v[i] = sc.nextInt();
            }
            System.out.println(findKnapsack(a,v,n,W));
            t--;
        }
    }
}
