import java.util.*;

/**
 * Created by ravinderk on 7/20/2016.
 */
public class BTPrintBottomView {
    public static void main(String[] args) {
        System.out.println("--------Sample-------");
        testSample();
        System.out.println("--------NULL-------");
        testNull();
        System.out.println("--------One-------");
        testOne();
        System.out.println("--------Two-------");
        testTwo();
        System.out.println("--------Three-------");
        testThree();
        System.out.println("--------Four-------");
        testFour();
        System.out.println("--------Sample2-------");
        testSample2();

    }

    /*
      15
    /   \
   10    20
  / \   /  \
 8  12 16  25
     */
    private static void testSample() {
        TNode root = new TNode(20);
        root.left = new TNode(8);
        root.right = new TNode(22);
        root.left.left = new TNode(5);
        root.left.right = new TNode(3);
        root.left.right.left = new TNode(10);
        root.left.right.left.left = new TNode(9);
        root.left.right.left.left.left = new TNode(21);
        root.left.right.right = new TNode(14);
        root.right.left = new TNode(4);
        root.right.right = new TNode(25);
        printBottomView(root);
        printTopView(root);
    }

    private static void testSample2(){
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.right = new TNode(4);
        root.left.right.right = new TNode(5);
        root.left.right.right.right = new TNode(6);
        printTopView(root);

    }

    private static void testOne() {
        TNode root = new TNode(97);
        printBottomView(root);
        printTopView(root);
    }

    private static void testNull() {
        printBottomView(null);
        printTopView(null);
    }

    private static void testTwo() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        printBottomView(root);
        printTopView(root);
    }

    private static void testThree() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new  TNode(37);
        printBottomView(root);
        printTopView(root);
    }

    /*
      97
    /   \
   46    37
  / \
 12  3
 */
    private static void testFour() {
        TNode root = new TNode(97);
        root.left = new TNode(46);
        root.right = new TNode(37);
        root.left.left = new TNode(12);
        root.left.right = new TNode(3);
        printBottomView(root);
        printTopView(root);
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
    
    static class QData {
        TNode node;
        int vD;

        public QData(TNode node, int vD) {
            this.node = node;
            this.vD = vD;
        }
    }

    static void printBottomView(TNode root) {
        if(root == null) return;
        Deque<QData> queue = new ArrayDeque<QData>();
        queue.push(new QData(root,0));
        Map<Integer, TNode> bottomView = new TreeMap<Integer, TNode>();
        while (!queue.isEmpty()) {
            QData nd = queue.pop();
            bottomView.put(nd.vD, nd.node);
            if(nd.node.left != null) {
                queue.push(new QData(nd.node.left, nd.vD - 1));
            }
            if(nd.node.right != null) {
                queue.push(new QData(nd.node.right, nd.vD + 1));
            }
        }
        
        for (Integer i : bottomView.keySet()) {
            System.out.print(bottomView.get(i).i+" ");
        }
        System.out.println();
    }

    static void printTopView(TNode root) {
        if(root == null) return;
        Deque<QData> queue = new ArrayDeque<QData>();
        queue.push(new QData(root,0));
        Map<Integer, TNode> bottomView = new TreeMap<Integer, TNode>();
        while (!queue.isEmpty()) {
            QData nd = queue.pop();
            if(bottomView.get(nd.vD) == null) {
                bottomView.put(nd.vD, nd.node);
            }
            if(nd.node.left != null) {
                queue.push(new QData(nd.node.left, nd.vD - 1));
            }
            if(nd.node.right != null) {
                queue.push(new QData(nd.node.right, nd.vD + 1));
            }
        }

        for (Integer i : bottomView.keySet()) {
            System.out.print(bottomView.get(i).i+" ");
        }
        System.out.println();
    }
}
