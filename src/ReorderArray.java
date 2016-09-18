import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class ReorderArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] indexArr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                indexArr[i] = sc.nextInt();
            }
            reorderArray(arr, indexArr, n);
            for(int i = 0 ; i < n ; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            for(int i = 0 ; i < n ; i++) {
                System.out.print(indexArr[i]+" ");
            }
            System.out.println();
            t--;
        }
    }

    private static void reorderArray(int[] arr, int[] indexArr, int n) {
        for (int i = 0 ; i < n;) {
            if(i == indexArr[i]) {
                i++;
            } else {
                //swap main arr
                int temp = arr[indexArr[i]];
                arr[indexArr[i]] = arr[i];
                arr[i] = temp;
                //swap indexArr
                temp = indexArr[indexArr[i]];
                indexArr[indexArr[i]] = indexArr[i];
                indexArr[i] = temp;
            }
        }
    }
}
