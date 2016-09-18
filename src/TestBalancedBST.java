import java.util.Arrays;

public class TestBalancedBST {
    public static void main(String[] args) {
        BinarySearchTree bst = convertLLToBalancedBST(new int[]{1,2,3,4,5});
        System.out.println(bst.findHeight());
        bst.printInOrder();
        bst = convertLLToBalancedBST(null);
        System.out.println(bst.findHeight());
        bst.printInOrder();
        bst = convertLLToBalancedBST(new int[]{1,12,8,20,5,3,4,4});
        System.out.println(bst.findHeight());
        bst.printInOrder();
    }

    private static BinarySearchTree convertLLToBalancedBST(int[] a) {
        BinarySearchTree bst = new BinarySearchTree();
        if(a== null || a.length==0) return bst;
        Arrays.sort(a);
        createBalancedBST(bst,a,0,a.length-1);
        return bst;
    }

    private static void createBalancedBST(BinarySearchTree bst, int[] a, int start, int end) {
        if(start > end) return;
        if(start == end) {
            bst.add(new TNode(a[start]));
            return;
        }
        int m = (start + end+1)/2;
        bst.add(new TNode(a[m]));
        createBalancedBST(bst, a, start, m-1);
        createBalancedBST(bst, a, m+1, end);
    }
}
