import java.util.Enumeration;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by ravinderk on 7/20/2016.
 */
public class PrintRootToLeafPaths {
    public static void main(String[] args) {
        testSample();
    }

    private static void printPaths(TNode root) {
        if(root == null) return ;
        Stack<TNode> stack = new Stack<TNode>();
        stack.push(root);
        HashMap<TNode, TNode> parent = new HashMap<TNode, TNode>();
        parent.put(root, null);
        while (!stack.empty()) {
            TNode top = stack.peek();
            stack.pop();
            
            if(isLeaf(top)) {
                printStack(top, parent);
            } 
            
            if(top.right != null){
                stack.push(top.right);
                parent.put(top.right, top);
            }

            if(top.left != null) {
                stack.push(top.left);
                parent.put(top.left, top);
            }
        }
    }

    private static void printStack(TNode node, HashMap<TNode, TNode> parent) {
        Stack<TNode> stack = new Stack<TNode>();
        while (node != null) {
            stack.push(node);
            node = parent.get(node);
        }

        while (!stack.empty()) {
            System.out.print(stack.pop().i+" ");
        }
        System.out.println();
    }

    private static boolean isLeaf(TNode node) {
        return node != null && node.left == null && node.right == null;
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

        printPaths(root);
    }

    private static void testOneTrue() {
        printPaths(new TNode(1));
    }

    private static void testNull() {
        printPaths(null);
    }

    private static void testTwoTrue() {
        TNode first = new TNode(1);
        first.left = new TNode(2);

        printPaths(first);
    }
}
