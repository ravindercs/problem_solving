import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class BinLongestSumSpan {
    public static void main(String[] arr) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            System.out.println(findLongestSpan(a, b, n));
            t--;
        }
    }

    private static int findLongestSpan(int[] a, int[] b, int n) {
        int len = 0;
        int s1 = 0;
        int s2 = 0;
        for (int i =0; i < n ; i++) {
            s1 += a[i];
            s2 += b[i];
        }

        if(s1 == s2) {
            return n;
        }

        for (int i=0, j=n-1; i<=j ;) {
            if(s1 > s2) {
                if(a[i] == 1 && b[i] == 0) {
                    i++;
                    s1--;
                } else if(a[j] == 1 && b[j] == 0) {
                    j--;
                    s1--;
                } else if(a[i] == 1 && b[i] == 1) {
                    i++; s1--; s2--;
                } else if(a[j] == 1 && b[j] == 1) {
                    j--; s1--; s2--;
                } else if(a[i] == 0 && b[i] == 0) {
                    i++;
                } else if(a[j] == 0 && b[j] == 0) {
                    j--;
                }
            } else if(s1 < s2) {
                if(a[i] == 0 && b[i] == 1) {
                    i++;
                    s2--;
                } else if(a[j] == 0 && b[j] == 1) {
                    j--;
                    s2--;
                } else if(a[i] == 1 && b[i] == 1) {
                    i++; s1--; s2--;
                } else if(a[j] == 1 && b[j] == 1) {
                    j--; s1--; s2--;
                } else if(a[i] == 0 && b[i] == 0) {
                    i++;
                } else if(a[j] == 0 && b[j] == 0) {
                    j--;
                }
            } else {
                len = j-i +1;
                break;
            }
        }

        return len;
    }
}
