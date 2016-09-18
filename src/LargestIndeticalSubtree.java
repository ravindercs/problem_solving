/**
 * Created by ravinderk on 7/20/2016.
 */
public class LargestIndeticalSubtree {
    public static void main(String[] args) {
        testSample();
        testNull();
        testOne();
        testTwo();
        testThree();
        testFour();
    }

    private static boolean areIdentical(TNode left, TNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        return left.i == right.i
                && areIdentical(left.left, right.left)
                && areIdentical(left.right, right.right);
    }

    private static int countNodes(TNode root) {
        if(root == null) return 0;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }


    private static void getIdenticalSubtreeUtil(TNode root) {
        Result result = getLargestIdenticalSubtree(root);
        if(result.largestSubtree != null && !isLeaf(result.largestSubtree)) {
            System.out.println(result.largestSubtree.i);
        }
    }

    static class Result {
        TNode largestSubtree;
        int count;

        public Result(int count, TNode largestSubtree) {
            this.count = count;
            this.largestSubtree = largestSubtree;
        }
    }

    private static Result getLargestIdenticalSubtree(TNode root){
        if(root == null) return new Result(0,null);

        if(areIdentical(root.left, root.right)) {
            return new Result(countNodes(root), root);
        }

        Result left = getLargestIdenticalSubtree(root.left);
        Result right = getLargestIdenticalSubtree(root.right);

        if(left.count > 0 && left.count > right.count) {
            return new Result(left.count + right.count + 1, left.largestSubtree);
        } else if(right.count > 0 && right.count > left.count){
            return new Result(left.count + right.count + 1, right.largestSubtree);
        }

        return new Result(left.count + right.count + 1, null);
    }


    private static void testSample() {
        TNode root = new TNode(50);
        root.left = new TNode(10);
        root.right = new TNode(60);
        root.left.left = new TNode(5);
        root.left.right = new TNode(20);
        root.right.left = new TNode(70);
        root.right.right = new TNode(70);
        root.right.left.left = new TNode(65);
        root.right.left.right = new TNode(80);
        root.right.right.left = new TNode(65);
        root.right.right.right = new TNode(80);
        getIdenticalSubtreeUtil(root);
    }

    private static boolean isLeaf(TNode node) {
        return node != null && node.left == null && node.right == null;
    }

    private static void testOne() {
        TNode root = new TNode(97);
        getIdenticalSubtreeUtil(root);
    }

    private static void testNull() {
        getIdenticalSubtreeUtil(null);
    }

    private static void testTwo() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        getIdenticalSubtreeUtil(root);
    }

    private static void testThree() {
        TNode root = new TNode(97);
        root.left = new TNode(37);
        root.right = new TNode(37);
        getIdenticalSubtreeUtil(root);
    }

    private static void testFour() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new TNode(37);
        root.left.left = new TNode(12);
        root.left.right = new TNode(12);
        getIdenticalSubtreeUtil(root);
    }

    static class TNode {
        int i;
        TNode left, right;

        public TNode(int i) {
            this.i = i;
            left = null;
            right = null;
        }
    }
}
