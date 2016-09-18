/**
 * Created by ravinderk on 7/5/2016.
 */
public class PrintSpiral {
//    For upper right half,
//    mat[i][j] = (n-2*x)*(n-2*x)-(i-x)-(j-x)
//
//    For lower left half,
//    mat[i][j] = (n-2*x-2)*(n-2*x-2) + (i-x) + (j-x)

    public static void main(String[] args) {
        printSpiral(1);
        System.out.println();
        printSpiral(2);
        System.out.println();
        printSpiral(3);
        System.out.println();
        printSpiral(4);
        System.out.println();
        printSpiral(5);
        System.out.println();
    }

    private static void printSpiral(int n) {
        for (int i =0; i < n; i++) {
            for (int j =0; j < n; j++) {
                int x = Math.min(Math.min(i,j), Math.min(n-i-1, n-j-1));
                if(i <= j) {
                    System.out.print((n-2*x)*(n-2*x)-(i-x)-(j-x)+ " ");
                } else {
                    System.out.print((n-2*x-2)*(n-2*x-2)+(i-x)+(j-x)+" ");
                }
            }
            System.out.println();
        }
    }

}