import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ravinderk on 6/28/2016.
 */
public class BinGenerator {
    private static void add(List<Character> number) {
        for(int i = number.size() -1 ; i >= 0 ; i--) {
            if(i == 0 && number.get(0) == '1') {
                number.set(0,'0');
                number.add(0,'1');
                return;
            }
            if(number.get(i) == '0') {
                number.set(i, '1');
                break;
            } else {
                number.set(i, '0');
            }
        }
    }

    private static void printBin(List<Character> number) {
        for(Character c : number) {
            System.out.print(c);
        }
        System.out.print(" ");
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Character> number = new ArrayList<Character>();
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            number.clear();
            System.out.print("1 ");
            number.add('1');
            for(int i =1; i<n ; i++) {
                add(number);
                printBin(number);
                System.out.println();
            }

            t--;
        }
    }
}
