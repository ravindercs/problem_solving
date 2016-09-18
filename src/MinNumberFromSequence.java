import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class MinNumberFromSequence {
    public static void main(String[] arr) {
        printLeast("IDID");
        printLeast("I");
        printLeast("DD");
        printLeast("II");
        printLeast("DIDI");
        printLeast("IIDDD");
        printLeast("DDIDDIID");
        printLeast("DDDDDDDD");
        printLeast("IIIIIIII");
        printLeast("IIIIDDDD");
        printLeast("DDDDIIII");
    }

    private static void printLeast(String arr) {
        // min_avail represents the minimum number which is
        // still available for inserting in the output vector.
        // pos_of_I keeps track of the most recent index
        // where 'I' was encountered w.r.t the output vector
        int min_avail = 1, pos_of_I = 0;

        //vector to store the output
        ArrayList<Integer> v = new ArrayList<Integer>();

        // cover the base cases
        if (arr.charAt(0)=='I')
        {
            v.add(1);
            v.add(2);
            min_avail = 3;
            pos_of_I = 1;
        }
        else
        {
            v.add(2);
            v.add(1);
            min_avail = 3;
            pos_of_I = 0;
        }

        // Traverse rest of the input
        for (int i=1; i<arr.length(); i++)
        {
            if (arr.charAt(i)=='I')
            {
                v.add(min_avail);
                min_avail++;
                pos_of_I = i+1;
            }
            else
            {
                v.add(v.get(i));
                for (int j=pos_of_I; j<=i; j++)
                    v.set(j, v.get(j) + 1);

                min_avail++;
            }
        }

        // print the number
        for (int i=0; i<v.size(); i++)
            System.out.print(v.get(i) + " ");
        System.out.println();
    }
}
