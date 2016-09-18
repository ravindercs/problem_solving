/**
 * Created by ravinderk on 7/18/2016.
 */

//{6, 2, 5, 4, 5, 2, 6}.

public class CountNegInSortedMatrix {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {-6, -4, -3,  -2},
                {-4, -3, -2,  -1},
                {-2, -1,  7,  8}};
        System.out.println(countNegatives(a));
    }

    private static int countNegatives(int[][] a) {
        if(a == null || a.length == 0) return 0;
        int j = a[0].length -1 ;
        int i = 0;
        int count = 0;
        while (i < a.length && j >= 0) {
            if(a[i][j] >= 0) {
                j--;
            } else {
                count += j + 1;
                i++;
            }
        }
        return count;
    }
}
