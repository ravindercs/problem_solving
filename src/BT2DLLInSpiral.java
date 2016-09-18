import java.util.*;

/**
 * Created by ravinderk on 7/20/2016.
 */
public class BT2DLLInSpiral {
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

    private static void convertToSpiralDLLUtil(TNode root) {
        TNode head = convertToSpiralDLL(root);
        while (head != null) {
            System.out.print(head.i+" ");
            head = head.right;
        }
        System.out.println();
    }

    private static TNode convertToSpiralDLL(TNode root) {
        if(root == null || root.right == null) return root;

        Deque<TNode> first = new LinkedList<TNode>();
        first.add(root);
        Deque<TNode> second = new LinkedList<TNode>();
        Stack<TNode> stack = new Stack<TNode>();
        boolean addLast = false;
        while (true) {
            while (!first.isEmpty()) {
                if(addLast) {
                    TNode front = first.pollFirst();
                    stack.push(front);
                    if (front.left != null) {
                        second.addLast(front.left);
                    }
                    if(front.right != null) {
                        second.addLast(front.right);
                    }
                } else {
                    TNode front = first.pollLast();
                    stack.push(front);
                    if (front.right != null) {
                        second.addFirst(front.right);
                    }
                    if(front.left != null) {
                        second.addFirst(front.left);
                    }
                }
            }

            if(second.isEmpty()) break;
            addLast = !addLast;
            Deque<TNode> temp = first;
            first = second;
            second = temp;
        }
        TNode head = null;
        while (!stack.empty()) {
            TNode node = stack.pop();
            node.left = null;
            node.right = head;
            head = node;
        }

        return head;
    }

    private static void testSample() {
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);

        root.left.left = new TNode(4);
        root.left.right = new TNode(5);

        root.left.left.left = new TNode(8);
        root.left.left.right = new TNode(9);

        root.left.right.left = new TNode(10);
        root.left.right.right = new TNode(11);

        root.right.left = new TNode(6);
        root.right.right = new TNode(7);

        root.right.left.right = new TNode(13);
        root.right.right.left = new TNode(14);

        convertToSpiralDLLUtil(root);
    }

    private static void testOne() {
        TNode root = new TNode(97);
        convertToSpiralDLLUtil(root);
    }

    private static void testNull() {
        convertToSpiralDLLUtil(null);
    }

    private static void testTwo() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        convertToSpiralDLLUtil(root);
    }

    private static void testThree() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new TNode(37);
        convertToSpiralDLLUtil(root);
    }

    private static void testFour() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new TNode(37);
        root.left.left = new TNode(12);
        root.left.right = new TNode(3);
        convertToSpiralDLLUtil(root);
    }
}
