import java.util.*;

/**
 * Created by ravinderk on 7/24/2016.
 */
public class BTPerfectBTBottomUpLevelOrder {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(new TNode(1));
        TNode root = bst.getRoot();
        root.left = new TNode(2);
        root.right = new TNode(3);

        root.left.left = new TNode(4);
        root.left.right = new TNode(5);

        root.right.left = new TNode(6);
        root.right.right = new TNode(7);

        root.left.left.left = new TNode(8);
        root.left.left.right = new TNode(9);
        root.left.right.left = new TNode(10);
        root.left.right.right = new TNode(11);

        root.right.left.left = new TNode(12);
        root.right.left.right = new TNode(13);
        root.right.right.left = new TNode(14);
        root.right.right.right = new TNode(15);


        printLevelOrder(bst);
        System.out.println();
        printSpecialLevelOrder(bst);
    }

    private static void printSpecialLevelOrder(BinarySearchTree bst) {
        if(bst == null) return;
        TNode root = bst.getRoot();
        if(root == null) return;
        Stack<TNode> stack = new Stack<TNode>();
        stack.push(root);

        if(root.left != null) {
            stack.push(root.right);
            stack.push(root.left);

            if (root.left.left != null)
                printLevelOrder(root, stack);
        }

        while (!stack.empty()) {
            System.out.print(stack.pop().i+" ");
        }
        System.out.println();
    }

    private static void printLevelOrder(TNode root, Stack<TNode> stack) {
        Deque<TNode> queue = new LinkedList<TNode>();
        queue.push(root.left);
        queue.push(root.right);

        while (!queue.isEmpty()) {
            TNode first = queue.remove();
            TNode second = queue.remove();

            stack.push(second.left);
            stack.push(first.right);
            stack.push(second.right);
            stack.push(first.left);

            if(first.left.left != null) {
                queue.push(first.right);
                queue.push(second.left);
                queue.push(first.left);
                queue.push(second.right);
            }
        }
    }

    private static void printLevelOrder(BinarySearchTree bst) {
        HashMap<Integer, List<TNode>> hM = new HashMap<Integer, List<TNode>>();
        doInorder(bst.getRoot(), 0, hM);
        Set<Integer> set = hM.keySet();
        int maxLevel = 0;
        for(Integer i : set) {
            maxLevel = Math.max(maxLevel, i);
        }
        for (int i = maxLevel; i>= 0; i--) {
            List<TNode> list = hM.get(i);
            for (int s = 0 , e = list.size()-1; s <= e ; s++, e-- ) {
                System.out.print(list.get(s).i+" "+(s == e ? "":list.get(e).i+" "));
            }
        }
    }

    private static void doInorder(TNode root, int level, HashMap<Integer, List<TNode>> hM) {
        if(root == null) return;
        doInorder(root.left, level+1, hM);
        List<TNode> list = hM.get(level);
        if(list == null) {
            list = new LinkedList<TNode>();
            hM.put(level, list);
        }
        list.add(root);
        doInorder(root.right, level+1, hM);
    }
}
