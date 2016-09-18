/**
 * Created by ravinderk on 7/20/2016.
 */
public class BinaryTreeDensityFinder {
    public static void main(String[] args) {
        testSample();
        System.out.println("----------------------");
        testNull();
        System.out.println("----------------------");
        testOne();
        System.out.println("----------------------");
        testTwo();
        System.out.println("----------------------");
        testThree();
        System.out.println("----------------------");
        testFour();
        System.out.println("----------------------");
    }

    static class Result {
        int height;
        int size;

        public Result(int height, int size) {
            this.height = height;
            this.size = size;
        }
    }

    private static void printDensity(TNode root) {
        Result result = printDensityUtil(root);
        if(result != null && result.height != 0) {
            System.out.println((double)result.size / (double) result.height);
        }
    }

    private static Result printDensityUtil(TNode root) {
        if(root == null) return new Result(0,0);
        Result left = printDensityUtil(root.left);
        Result right = printDensityUtil(root.right);
        int h = Math.max(left.height, right.height) + 1;
        int s = left.size + right.size + 1;
        return new Result(h,s);
    }

    private static void testSample() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new TNode(37);
        root.left.left = new TNode(12);
        root.left.right = new TNode(3);
        root.right.left = new TNode(7);
        root.right.right = new TNode(31);
        root.left.right.left = new TNode(2);
        root.left.right.right = new TNode(4);
        printDensity(root);
    }

    private static void testOne() {
        TNode root = new TNode(97);
        printDensity(root);
    }

    private static void testNull() {
        printDensity(null);
    }

    private static void testTwo() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        printDensity(root);
    }

    private static void testThree() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new TNode(37);
        printDensity(root);
    }

    private static void testFour() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new TNode(37);
        root.left.left = new TNode(12);
        root.left.right = new TNode(3);
        printDensity(root);
    }
}
