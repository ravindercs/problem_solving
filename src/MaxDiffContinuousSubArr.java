import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class MaxDiffContinuousSubArr {
    public static void main(String[] arr) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(maxBF(a,n));
            System.out.println(maxDiff(a,n));
            t--;
        }
    }

    private static int maxBF(int[] a, int n) {
        int diff = 0;
        for (int i = 0 ; i < n ; i++) {
            int s1 = 0;
            for (int j = i ; j < n ; j++) {
                s1 += a[j];
                int s2 = 0;
                for (int k = j+1 ; k < n ; k++){
                    s2 += a[k];
                    if(s1 < s2) {
                        if(s2-s1 > diff) {
                            diff = s2-s1;
                        }
                    } else {
                        if(s1-s2 > diff) {
                            diff = s1-s2;
                        }
                    }
                }
            }
        }
        return diff;
    }

    private static int maxDiff(int[] a, int n) {
        int[] leftMax = leftMax(a,n);
        int[] rightMax = rightMax(a,n);
        int[] invertArr = invertArray(a,n);
        int[] leftMin = leftMax(invertArr,n);
        for (int i = 0; i < n ; i++) {
            leftMin[i] = -leftMin[i];
        }
        int[] rightMin = rightMax(invertArr,n);
        for (int i = 0; i < n ; i++) {
            rightMin[i] = -rightMin[i];
        }
        int maxDiff = 0;
        for (int i = 0 ; i < n-1 ; i++) {
            int r = Math.max(Math.abs(leftMax[i] - rightMax[i+1]), Math.abs(leftMin[i] - rightMax[i+1]));
            if(r > maxDiff) {
                maxDiff = r;
            }
        }
        return maxDiff;
    }

    private static int[] invertArray(int[] a, int n) {
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = -a[i];
        }
        return arr;
    }

    private static int[] leftMax(int[] a, int n) {
        int[] leftMax = new int[n];
        int max_so_far = a[0];
        int max = a[0];
        leftMax[0] = a[0];

        for(int i = 1; i < n; i++) {
            max = Math.max(max, max+a[i]);
            max_so_far = Math.max(max_so_far, max);
            leftMax[i] = max_so_far;
        }
        return leftMax;
    }

    private static int[] rightMax(int[] a, int n) {
        int[] rightMax = new int[n];
        int max_so_far = a[n-1];
        int max = a[n-1];
        rightMax[0] = a[n-1];

        for(int i = n-2; i >= 0 ; i--) {
            max = Math.max(max, max+a[i]);
            max_so_far = Math.max(max_so_far, max);
            rightMax[i] = max_so_far;
        }
        return rightMax;
    }
}
