/**
 * Created by ravinderk on 7/5/2016.
 */
public class RotateMatrix {
    public static void main(String[] args) {
        rotate(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
    }

    private static void rotate(int[][] a) {
        print(a);
        System.out.println();
        flip(a);
        transpose(a);
        print(a);
    }

    private static void flip(int[][] a){
        for (int i = 0 ; i < a.length; i++) {
            for(int j = 0; j < a[0].length/2; j++) {
                int t = a[i][j];
                a[i][j] = a[i][a[0].length - j - 1];
                a[i][a[0].length - j - 1] = t;
            }
        }
    }

    private static void transpose(int[][] a){
        for(int i = 0 ; i < a.length; i++) {
            for (int j = 0 ; j < i; j++) {
                int t = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = t;
            }
        }
    }

    private static void print(int[][] a) {
        for (int i = 0 ; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}