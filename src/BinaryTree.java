/**
 * Created by ravinderk on 7/20/2016.
 */
public class BinaryTree {
    private TNode root;

    public BinaryTree() {
        root = null;
    }

    BinaryTree(TNode root) {
        this.root = root;
    }

    public boolean isCompleteTree() {
        int n = countNodes();
        return isCompleteTree(root, 0, n);
    }

    public boolean isCompleteTree(TNode root, int i, int n) {
        return root == null || i<n && isCompleteTree(root.left, 2*i+1, n) && isCompleteTree(root.right, 2*i+2, n);
    }

    public int countNodes() {
        return countNodes(root);
    }

    public int countNodes(TNode root) {
        return getCount(root);
    }

    public void printInOrder() {
        printInOrder(root);
        System.out.println();
    }

    public void printInOrder(TNode root) {
        if(root == null) return;
        printInOrder(root.left);
        System.out.print(root.i+" ");
        printInOrder(root.right);
    }


    public void printPostOrder() {
        printPostOrder(root);
        System.out.println();
    }

    public void printPostOrder(TNode root) {
        if(root == null) return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.i+" ");
    }

    public static int findHeight(TNode root) {
        if(root == null) return 0;
        int l = findHeight(root.left);
        int r = findHeight(root.right);
        return Math.max(l,r)+1;
    }

    public static int getCount(TNode root) {
        if(root == null) return 0;

        return 1+ getCount(root.left) + getCount(root.right);
    }
}
