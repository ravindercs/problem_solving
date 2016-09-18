import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree {
    TNode root;

    public TNode getRoot() {
        return root;
    }

    public void add(int i) {
        add(new TNode(i));
    }

    public void add(TNode node) {
        if(node == null) return;
        if(root == null) {
            root = node;
        } else {
            add(root,node);
        }
    }


    private void add(TNode root, TNode node) {
        if(root.i < node.i) {
            if(root.right == null) {
                root.right = node;
            } else {
                add(root.right, node);
            }
        } else {
            if(root.left == null) {
                root.left = node;
            } else {
                add(root.left, node);
            }
        }
    }

    public int getCount() {
        return getCount(root);
    }

    private int getCount(TNode root) {
        if(root == null) return 0;
        return getCount(root.left) + getCount(root.right) + 1;
    }

    public void printInOrder() {
        _printInOrder(root);
        System.out.println();
    }

    private void _printInOrder(TNode root) {
        if(root == null) return;
        _printInOrder(root.left);
        System.out.print(root.i+" ");
        _printInOrder(root.right);
    }

    public int findHeight() {
        return _findHeight(root);
    }

    private int _findHeight(TNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int l = _findHeight(root.left);
        int r = _findHeight(root.right);
        return Math.max(l,r) +1;
    }

    public void printLevelOrder() {
        if(root == null) return;
        Queue<TNode> first = new ArrayDeque<TNode>();
        Queue<TNode> second = new ArrayDeque<TNode>();
        first.add(root);
        while (true) {
            while (!first.isEmpty()) {
                TNode node = first.remove();
                System.out.print(node.i+" ");
                if (node.left != null) second.add(node.left);
                if (node.right != null) second.add(node.right);
            }

            System.out.println();

            if(second.isEmpty()) break;

            Queue<TNode> t = first;
            first = second;
            second = t;
        }

        System.out.println();
    }

    public void setRoot(TNode root) {
        this.root = root;
    }

    public void printPreOrderOrder() {
        _printPreOrder(root);
        System.out.println();
    }

    private void _printPreOrder(TNode root) {
        if(root == null) return;
        System.out.print(root.i+" ");
        _printPreOrder(root.left);
        _printPreOrder(root.right);
    }
}
