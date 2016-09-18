/**
 * Created by ravinderk on 7/24/2016.
 */
public class BTDiameterFinder {
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
        System.out.println(getDiameter(null));
    }

    private static void testOne() {
        System.out.println("Testing One");
        System.out.println(getDiameter(new TNode(1)));
    }

    private static void testTwo() {
        System.out.println("Testing Two");
        TNode root = new TNode(1);
        root.right = new TNode(2);
        System.out.println(getDiameter(root));
    }

    private static void testThreeTrue() {
        System.out.println("Testing Three True");
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        System.out.println(getDiameter(root));
    }

    private static void testThreeFalse() {
        System.out.println("Testing Three False");
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.left.left = new TNode(3);
        System.out.println(getDiameter(root));
    }

    private static void testSampleTrue() {
        System.out.println("Testing Sample True");
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.left.left = new TNode(2);
        root.left.right = new TNode(2);
        root.left.right.left = new TNode(2);
        root.left.right.right = new TNode(2);

        root.right = new TNode(3);
        root.right.right = new TNode(6);
        root.right.right.right = new TNode(6);
        root.right.right.right.left = new TNode(6);
        root.right.right.right.left.left = new TNode(6);
        root.right.right.right.left.right = new TNode(6);
        root.right.right.right.right = new TNode(6);

        System.out.println(getDiameter(root));
    }

    private static void testSampleFalse() {
        System.out.println("Testing Sample False");
        TNode root = new TNode(1);
        root.right = new TNode(3);
        root.right.right = new TNode(3);

        root.left = new TNode(2);
        root.left.left = new TNode(4);
        root.left.right = new TNode(5);

        root.left.left.left = new TNode(4);
        root.left.left.right = new TNode(4);

        root.left.left.right = new TNode(5);
        root.left.left.right.left = new TNode(5);
        root.left.left.right.left.left = new TNode(5);
        root.left.left.right.left.right = new TNode(5);

        root.left.right.right = new TNode(5);
        root.left.right.right.left = new TNode(5);
        root.left.right.right.right = new TNode(5);
        root.left.right.right.right.right = new TNode(5);

        System.out.println(getDiameter(root));
    }

    private static int getDiameter(TNode root) {
       if(root == null) return 0;
        int l = BinaryTree.findHeight(root.left);
        int r = BinaryTree.findHeight(root.right);

        int dl = getDiameter(root.left);
        int dr = getDiameter(root.right);

        return Math.max(l+r+1,Math.max(dl,dr));
    }

}
