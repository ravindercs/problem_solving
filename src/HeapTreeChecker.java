/**
 * Created by ravinderk on 7/23/2016.
 */
public class HeapTreeChecker {
    public static void main(String[] args) {
        testHeapTree();
        testNonHeapTree();
    }

    private static void testNonHeapTree() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new TNode(37);
        root.left.left = new TNode(12);
        root.left.right = new TNode(3);
        root.right.left = new TNode(7);
        root.right.right = new TNode(31);
        root.left.right.left = new TNode(2);
        root.left.right.right = new TNode(4);

        System.out.println(isHeapUtil(root));
    }

    private static boolean isHeapUtil(TNode root) {
        if(root == null) return true;
        BinaryTree bt = new BinaryTree(root);
        int n = bt.countNodes(root);

        boolean isHeap =  isMaxHeap(root);

        if(isHeap) {
            isHeap = bt.isCompleteTree(root,0,n);
        }

        return isHeap;
    }


    private static void testHeapTree() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new TNode(37);
        root.left.left = new TNode(12);
        root.left.right = new TNode(3);
        root.right.left = new TNode(7);
        root.right.right = new TNode(31);
        root.left.left.left = new TNode(6);
        root.left.left.right = new TNode(9);

        System.out.println(isHeapUtil(root));
    }
    private static boolean isMaxHeap(TNode root) {
        if(root == null) return true;
        boolean res = true;
        if(root.left != null) {
            res = root.i > root.left.i && isMaxHeap(root.left);
        }

        if(res && root.right != null) {
            res = root.i > root.right.i && isMaxHeap(root.right);
        }
        return res;
    }
}
