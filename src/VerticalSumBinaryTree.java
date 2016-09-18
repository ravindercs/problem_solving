import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ravinderk on 7/20/2016.
 */
public class VerticalSumBinaryTree {
    public static void main(String[] args) {
        testSample();
        testNull();
        testOne();
        testTwo();
        testThree();
        testFour();
    }

    private static void getVerticalSum(TNode root) {
        if(root == null) return;
        DoublyLinkedList list = new DoublyLinkedList(0);
        getVerticalSum(root, list.head);
        while (list.head.prev != null) {
            list.head = list.head.prev;
        }

        list.printList();
    }

    private static void getVerticalSum(TNode root, DLLNode node) {
        node.i += root.i;
        if(root.left != null) {
            if(node.prev == null) {
                DLLNode newNode = new DLLNode(0);
                newNode.next = node;
                node.prev = newNode;
            }
            getVerticalSum(root.left, node.prev);
        }
        if(root.right != null) {
            if(node.next == null) {
                DLLNode newNode = new DLLNode(0);
                newNode.prev = node;
                node.next = newNode;
            }
            getVerticalSum(root.right, node.next);
        }
    }

    private static void getVerticalSumHM(TNode root) {
        if(root == null) return;
        HashMap<Integer, Integer> hM = new LinkedHashMap<Integer, Integer>();
        getVerticalSumHM(root, 0, hM);
        for (Map.Entry<Integer, Integer> e : hM.entrySet()) {
            System.out.print(e.getValue()+" ");
        }
        System.out.println();
    }

    private static void getVerticalSumHM(TNode root, int hD, HashMap<Integer, Integer> hM) {
        if(root.left != null) {
            getVerticalSumHM(root.left, hD-1, hM);
        }
        Integer prevSum = hM.get(hD);
        hM.put(hD, (prevSum == null ? 0 : prevSum ) + root.i);
        if(root.right != null) {
            getVerticalSumHM(root.right, hD+1, hM);
        }
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
        getVerticalSum(root);
        getVerticalSumHM(root);
    }

    private static void testOne() {
        TNode root = new TNode(97);
        getVerticalSum(root);
        getVerticalSumHM(root);
    }

    private static void testNull() {
        getVerticalSum(null);
        getVerticalSumHM(null);
    }

    private static void testTwo() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        getVerticalSum(root);
        getVerticalSumHM(root);
    }

    private static void testThree() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new TNode(37);
        getVerticalSum(root);
        getVerticalSumHM(root);
    }

    private static void testFour() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new TNode(37);
        root.left.left = new TNode(12);
        root.left.right = new TNode(3);
        getVerticalSum(root);
        getVerticalSumHM(root);
    }
}
