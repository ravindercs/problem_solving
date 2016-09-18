/**
 * Created by ravinderk on 7/28/2016.
 */
public class LList2BSTConvertor {
    public static void main(String[] args) {
        testNull();
        testEmpty();
        testOne();
        testTwo();
        testThree();
        test1();
    }

    private static void testNull() {
        BinarySearchTree bst = convertLL2BST(null);
        bst.printLevelOrder();
    }

    private static void testEmpty() {
        BinarySearchTree bst = convertLL2BST(new LList(null));
        bst.printLevelOrder();
    }

    private static void testOne() {
        BinarySearchTree bst = convertLL2BST(new LList(new Node(1)));
        bst.printLevelOrder();
    }


    private static void testTwo() {
        LList list = new LList(new Node(1));
        list.addNodeAtLast(2);
        BinarySearchTree bst = convertLL2BST(list);
        bst.printLevelOrder();
    }

    private static void testThree() {
        LList list = new LList(new Node(1));
        list.addNodeAtLast(2);
        list.addNodeAtLast(3);
        BinarySearchTree bst = convertLL2BST(list);
        bst.printLevelOrder();
    }

    private static void test1() {
        LList lList = new LList(new Node(1));
        lList.addNodeAtLast(2);
        lList.addNodeAtLast(3);
        lList.addNodeAtLast(4);
        lList.addNodeAtLast(5);
        lList.addNodeAtLast(6);
        lList.addNodeAtLast(7);

        BinarySearchTree bst = convertLL2BST(lList);
        bst.printLevelOrder();
    }

    private static BinarySearchTree convertLL2BST(LList lList) {
        if(lList == null) return new BinarySearchTree();
        BinarySearchTree bst = new BinarySearchTree();
        int n = lList.size();
        LNode lNode = new LNode();
        lNode.node = lList.getHead();
        bst.setRoot(convertLL2BST(lNode, n));
        return bst;
    }

    static class LNode {
        Node node;
    }

    //1->2->3->4->5->6
    private static TNode convertLL2BST(LNode lnode, int n) {
        if(n <= 0) return null;
        TNode left = convertLL2BST(lnode, n/2);
        TNode root = new TNode(lnode.node.i);
        lnode.node = lnode.node.next;
        TNode right = convertLL2BST(lnode, n - n/2 - 1);
        root.left = left;
        root.right = right;
        return root;
    }
}
