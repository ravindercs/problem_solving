import java.util.Stack;

/**
 * Created by ravinderk on 7/28/2016.
 */
public class ArrPreorderValidator {
    public static void main(String[] args) {
        test1(new int[]{2, 4, 3}, "One");
        test1(new int[]{2, 4, 1}, "Two");
        test1(new int[]{40, 30, 35, 80, 100}, "Three");
        test1(new int[]{40, 30, 35, 20, 80, 100}, "Four");
    }

    //find first element greater than root and then check whether elements after that are all greater than root
    private static boolean isPreOrder(int[] pre) {
        if(pre == null || pre.length == 0) return false;

        if(pre.length == 1) return true;

        int root = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0 ; i < pre.length; i++) {
            if(pre[i] < root) {
                return false;
            }

            while (!s.empty() && s.peek() < pre[i]) {
                root = s.pop();
            }

            s.push(pre[i]);
        }

        return true;
    }

    private static void printNGE(int[] a) {
        if(a == null || a.length == 0) return;
        int[] b = new int[a.length];
        Stack<Integer> s = new Stack<Integer>();
        s.push(0);
        for (int i = 1; i < a.length; i++) {
            while (!s.empty() && a[i] > a[s.peek()]) {
                //System.out.print(a[s.peek()]+"->"+a[i]+" ");
                b[s.peek()] = a[i];
                s.pop();
            }
            s.push(i);
        }

        while (!s.empty()) {
            //System.out.print(s.peek()+"-> -1 ");
            b[s.peek()] = -1;
            s.pop();
        }

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+" ");
        }
        System.out.println();
    }

    private static void test1(int[] a, String name) {
        System.out.println("-----Test "+name+"--------");
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0 ; i < a.length; i++) {
            System.out.print(a[i]+" ");
            bst.add(a[i]);
        }
        System.out.println();

        bst.printPreOrderOrder();

        System.out.println(isPreOrder(a));
        printNGE(a);
    }
}
