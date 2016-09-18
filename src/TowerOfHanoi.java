/**
 * Created by ravinderk on 7/31/2016.
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        test(1);
        test(2);
        test(3);
        test(4);
        test(5);
        test(6);
        test(7);
        test(8);
    }

    private static void test(int n) {
        System.out.println("-----Tower of Hanoi for "+n+"---------");
        towerOfHanoi(n, 'A', 'C', 'B');
    }

    private static void towerOfHanoi(int n, char from, char to, char via) {
        if(n == 1) {
            System.out.println(String.format("Move %c to %c", from, to));
            return;
        }
        towerOfHanoi(n-1, from, via, to);
        System.out.println(String.format("Move %c to %c", from, to));
        towerOfHanoi(n-1, via, to, from);
    }
}
