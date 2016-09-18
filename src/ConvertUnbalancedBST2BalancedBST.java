import java.util.LinkedList;
import java.util.List;

/**
 * Created by ravinderk on 7/24/2016.
 */
public class ConvertUnbalancedBST2BalancedBST {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(new TNode(30));
        TNode root = bst.getRoot();
        root.left = new TNode(20);
        root.left.left = new TNode(10);

        System.out.println("----------Before----------");
        bst.printLevelOrder();
        System.out.println("----------After----------");
        bst = getBalancedBST(bst);
        bst.printLevelOrder();
    }

    private static void test2() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(new TNode(4));
        TNode root = bst.getRoot();
        root.left = new TNode(3);
        root.left.left = new TNode(2);
        root.left.left.left = new TNode(1);
        System.out.println("----------Before----------");
        bst.printLevelOrder();
        System.out.println("----------After----------");
        bst = getBalancedBST(bst);
        bst.printLevelOrder();
    }

    private static void test3() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(new TNode(4));
        TNode root = bst.getRoot();
        root.left = new TNode(3);
        root.left.left = new TNode(2);
        root.left.left.left = new TNode(1);

        root.right = new TNode(5);
        root.right.right = new TNode(6);
        root.right.right.right = new TNode(7);

        System.out.println("----------Before----------");
        bst.printLevelOrder();
        System.out.println("----------After----------");
        bst = getBalancedBST(bst);
        bst.printLevelOrder();
    }

    private static BinarySearchTree getBalancedBST(BinarySearchTree bst) {
        List<TNode> inorder = new LinkedList<TNode>();
        doInorder(bst.getRoot(), inorder);
        BinarySearchTree bbst = new BinarySearchTree();
        convertToBalancedBST(bbst, inorder, 0, inorder.size()-1);
        return bbst;
    }

    private static void convertToBalancedBST(BinarySearchTree bbst, List<TNode> inorder, int i, int j) {
        if(i > j) return;
        int m = (i+j)/2;
        bbst.add(inorder.get(m));
        convertToBalancedBST(bbst, inorder, i, m-1);
        convertToBalancedBST(bbst, inorder, m+1,j);
    }

    private static void doInorder(TNode root, List<TNode> list) {
        if(root == null) return;
        TNode left = root.left;
        TNode right = root.right;
        root.left = null;
        root.right = null;
        doInorder(left, list);
        list.add(root);
        doInorder(right, list);
    }
}
