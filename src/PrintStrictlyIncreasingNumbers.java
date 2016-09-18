import java.util.Arrays;

/**
 * Created by ravinderk on 8/22/2016.
 */
public class PrintStrictlyIncreasingNumbers {
    public static void main(String[] args) {
        printNumbers(1);
        printNumbers(2);
        printNumbers(3);
    }

    private static void printNumbers(int n) {
        if(n < 1 || n > 9) return;
        int[] a = new int[n];
        printNumbersUtil(0, 10-n, a, 0, n);
    }

    //01 02 03 ... 09 12 13 ....19 23 24 .... 34 35...45....89
    //0 1 2 3  4 5 6 7 8 9
    private static void printNumbersUtil(int i, int j, int[] a, int ix, int n) {
        if(ix < n) {
            for (int k = i; k <= j; k++) {
                a[ix] = k;
                printNumbersUtil(k + 1, j + 1, a, ix + 1, n);
                if(k != j)
                System.out.println(Arrays.toString(a));
            }
        }
    }
}
