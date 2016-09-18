/**
 * Created by ravinderk on 7/24/2016.
 */
public class BTHeightBalancedChecker {
    public static void main(String[] args) {
        testSampleTrue();
        testSampleFalse();
        testNull();
        testOne();
        testThreeFalse();
        testThreeTrue();
        testTwo();
    }

    private static void testNull() {
        System.out.println("Testing Null");
        assert isHeightBalanced(null);
    }

    private static void testOne() {
        System.out.println("Testing One");
        assert isHeightBalanced(new TNode(1));
    }

    private static void testTwo() {
        System.out.println("Testing Two");
        TNode root = new TNode(1);
        root.right = new TNode(2);
        assert isHeightBalanced(root);
    }

    private static void testThreeTrue() {
        System.out.println("Testing Three True");
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        assert isHeightBalanced(root);
    }

    private static void testThreeFalse() {
        System.out.println("Testing Three False");
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.left.left = new TNode(3);
        assert !isHeightBalanced(root);
    }

    private static void testSampleTrue() {
        System.out.println("Testing Sample True");
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.right.right = new TNode(6);
        root.left.left = new TNode(4);
        root.left.right = new TNode(5);
        root.left.right.left = new TNode(7);

        assert isHeightBalanced(root);
    }

    private static void testSampleFalse() {
        System.out.println("Testing Sample False");
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.left = new TNode(4);
        root.left.right = new TNode(5);
        root.left.right.left = new TNode(6);
        root.left.right.left.left = new TNode(7);

        assert !isHeightBalanced(root);
    }

    private static boolean isHeightBalanced(TNode root) {
        return isHeightBalancedUtil(root) >= 0;
    }

    private static int isHeightBalancedUtil(TNode root) {
        if(root == null) return 0;
        int l = isHeightBalancedUtil(root.left);
        int r = isHeightBalancedUtil(root.right);
        if(l >= 0 && r >= 0 && Math.abs(l-r) <= 1) {
            return Math.max(l,r) + 1;
        }
        return -1;
    }
}
