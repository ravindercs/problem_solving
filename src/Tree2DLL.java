/**
 * Created by ravinderk on 7/21/2016.
 */
public class Tree2DLL {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(4);
        bst.add(2);
        bst.add(1);
        bst.add(3);
        bst.add(6);
        bst.add(5);
        bst.add(7);
        bst.printLevelOrder();
        TNode dll = tree2DLL(bst.getRoot());
        printDll(dll);
    }

    static class LNode {
        TNode head;
    }

    private static void printDll(TNode head) {
        TNode node = head;
        while (node.right != head) {
            System.out.print(node.i+" ");
            node = node.right;
        }
        System.out.println(node.i);
        head = node;
        while (node.left != head) {
            System.out.print(node.i+" ");
            node = node.left;
        }
        System.out.println(node.i);
    }

    private static TNode tree2DLL(TNode root) {
        if(root == null) return null;

        TNode left = tree2DLL(root.left);
        TNode right = tree2DLL(root.right);

        root.right = root;
        root.left = root;

        left = merge(left, root);

        return merge(left, right);
    }

    private static TNode merge(TNode left, TNode right) {
        if(left == null) return right;
        if(right == null) return left;

        TNode llast = left.left;
        TNode rlast = right.left;

        left.left = rlast;
        right.left = llast;
        llast.right = right;
        rlast.right = left;

        return left;
    }
}
