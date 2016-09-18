import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ravinderk on 6/28/2016.
 */
public class Groups {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Character> number = new ArrayList<Character>();
        int t = sc.nextInt();
        int[] a = new int[80];
        while (t > 0)
        {
            int n = sc.nextInt();
            for(int i = 0; i < n ; i++) {
                a[i] = sc.nextInt();
            }

            System.out.println(countGroups(a, n));

            t--;
        }
    }

    private static int countGroups(int[] a, int n) {
        int count = 0;
        for(int i = 0 ; i < n ; i++) {
            for (int j = i+1 ; j < n ; j++) {
                if((a[i] + a[j])%3 == 0) {
                    count++;
                }
                for (int k = j+1 ; k < n ; k++) {
                    if ((a[i] + a[j] + a[k]) % 3 == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

}
