/**
 * Created by ravinderk on 7/19/2016.
 */
public class FindK {
    public static void main(String[] args){
        System.out.println(findK(new int[][]{
                {1, 0, 0, 0},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {1, 1, 1, 0},
        }));

        System.out.println(findKInOrderN(new int[][]{
                {1, 0, 0, 0},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {1, 1, 1, 0},
        }));

        System.out.println(findK(new int[][]{{0, 1, 1, 0, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1}}));
        System.out.println(findKInOrderN(new int[][]{{0, 1, 1, 0, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1}}));

        System.out.println(findK(new int[][]{{0, 1, 1, 0, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {1, 0, 1, 1, 0},
                {1, 1, 1, 1, 1}}));

        System.out.println(findKInOrderN(new int[][]{{0, 1, 1, 0, 1},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {1, 0, 1, 1, 0},
                {1, 1, 1, 1, 1}}));
    }

    private static int findK(int[][] a){
        int k =0;
        while(k < a.length) {
            //Checking column
            int i = 0;
            while (i < a.length) {
                if(i!=k && a[i][k] != 1) {
                    break;
                }
                i++;
            }

            if(i == a.length) {
                int j = 0;
                while (j < a[0].length) {
                    if (j != k && a[k][j] != 0) {
                        break;
                    }
                    j++;
                }
                if(j == a[0].length) {
                    return k;
                }
            }

            k++;
        }

        return -1;
    }

    private static int findKInOrderN(int[][] a){
        int res = -1;
        for (int i = 0,j=a[0].length-1 ; i < a.length && j >= 0; ) {
            if(a[i][j] == 0){
                while (j >= 0 && (i==j || a[i][j] == 0)) j--;
                if(j == -1) {
                    res = i;
                    break;
                } else {
                    i++;
                }
            } else {
                while (i< a.length && (i==j || a[i][j] == 1)) i++;
                if(i == a.length) {
                    res = j;
                    break;
                } else {
                    j--;
                }
            }
        }

        if(res == a.length) res = -1;
        if(res != -1) {
            int i = 0;
            for (; i < a.length; i++) {
                if(i != res && a[i][res] != 1) {
                    break;
                }
            }
            if(i == a.length) {
                i = 0;
                for (; i < a.length; i++) {
                    if(i != res && a[res][i] != 0) {
                        break;
                    }
                }

                if(i != a[0].length) {
                    res = -1;
                }
            } else {
                res = -1;
            }
        }

        return res;
    }
}
