import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class RearrangeIndexValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            //rearrangeUtil(arr, n);
            rearrangeByModulo(arr, n);
            for (int i = 0 ; i < n ; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            t--;
        }
    }

    private static boolean rearrangeUtil(int[] arr, int n) {

        for (int i = 0 ; i < n ; i++) {
            arr[i] += 1;
        }

        for (int i = 0 ; i < n; i++) {
            if(arr[i] > 0) {
                rearrange(arr, n , i);
            }
        }

        for (int i = 0 ; i < n ; i++) {
            arr[i] = (-arr[i]) - 1;
        }

        return false;
    }

    private static void rearrange(int[] arr, int n, int i) {
        int val = -(i + 1);
        i = arr[i] - 1;
        while (arr[i] > 0) {
            int new_i = arr[i] - 1;
            arr[i] = val;
            val = -(i+1);
            i = new_i;
        }
    }

    private static void rearrangeByModulo(int[] arr, int n){
        for (int i = 0 ; i < n ; i++) {
            arr[arr[i]%n] += (i*n); // if a[i] = j => j or i*n + j => we retrieve j by modulo
        }

        // Now all values are i*n+j => we retrieve i by division
        for (int i = 0 ; i < n ; i++) {
            arr[i] = arr[i]/n;
        }
    }
}

/*
look... the idea was to store the information of two numbers at a single memory location
 such that both the numbers can be retrieved if required....
 that way during one scan, i can store a combination of two numbers in each cell...
  one the original and one the updated, and in the second i can convert each data element to its updated version..
Now i can store things at one point by either
1. Using XOR ( as in memory efficient doubly linked list, search for this )
2. Or using the beauty of the modulo..
What i did here was this,
 I knew that every location will have an element less than n since it has to represent an index of the array,
  For any number x, such that x is less than n, x%n = x basically when i write, arr[arr[i]%n] and if arr[i]=j
i'm accessing the element at arr[j]
now you'll notice , i'm incrementing each such element with n*i
at this step, i'm storing two elements in one location,
For eg: suppose arr[2]=5 and arr[5]=4 and there are 6 elements in total
i'll make arr[arr[2]%6]=arr[5%6]=arr[5]= 4+12 i.e. 4 + 2*6
which is equal to 16
now this contains both the numbers,
if i wan't the original number, i.e. during the first scan when i'm changing all the values,
i write arr[5]%6 = (4 + 2*6)%6
= 4%6 + 2*6%6
= 4 + 0
= 4
and during the second scan, when i want to update the array to the final resultant
arr[5]/6 = (4 +2*6)/6
= 4/6 + 2*6/6
= 0 + 2
= 2
I hope this explanation helps you, all the best
 */