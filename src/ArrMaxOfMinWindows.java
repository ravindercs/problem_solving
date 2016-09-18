import java.util.Arrays;

/**
 * Created by ravinderk on 7/30/2016.
 */
public class ArrMaxOfMinWindows {
    public static void main(String[] args) {
        test(new int[]{10, 20, 30, 50, 10, 70, 30});
    }

    private static void test(int[] a) {
        if(a == null || a.length == 0) return;

        int[] s = new int[a.length];
        int[] m = new int[a.length];

        int max = Integer.MIN_VALUE;
        for (Integer i : a) {
            max = Math.max(max, i);
        }

        m[0] = max;
        max = Integer.MIN_VALUE;
        int ws = 2;
        for (int i = 0 ; i+ws <= a.length; i++ ) {
            s[i] = Math.min(a[i], a[i+ws-1]);
            max = Math.max(max, s[i]);
        }
        m[1] = max;
        while (ws < a.length) {
            ws++;
            for (int i = 0; i + ws <= a.length; i++) {
                s[i] = Math.max(a[i], s[i + 1]);
                m[ws-1] = Math.min(s[i], a[i]);
            }
        }

        System.out.println(Arrays.toString(m));
    }
}
