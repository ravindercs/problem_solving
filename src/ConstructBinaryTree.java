/**
 * Created by ravinderk on 7/20/2016.
 */
public class ConstructBinaryTree {
    public static void main(String[] args) {
        testSample();
        testNull();
        testOne();
        testTwo();
        testThree();
    }

//    in[]   = {2, 1, 3}
//    post[] = {2, 3, 1}
    private static void constructBT(int[] in, int[] post) {
        if(in == null || in.length <= 1) return ;
        if(post == null || post.length <= 1) return ;
        if(in.length != post.length) return ;
        TNode root = constructBTUtil(in, 0, in.length-1, post, new Index(post.length-1));
        BinaryTree bt = new BinaryTree(root);
        bt.printInOrder();
        bt.printPostOrder();
    }
    //    in[]   = {1, 2}
    //    post[] = {1, 2}
    static class Index {
        int i;

        public Index(int i) {
            this.i = i;
        }
    }

    private static TNode constructBTUtil(int[] in, int s, int e, int[] post, Index i) {
        if(s > e) {
            return null;
        }

        TNode node = new TNode(post[i.i]);
        i.i--;
        if(s == e) return node;

        int r = getIndex(in, s, e, node.i);
        node.right = constructBTUtil(in, r+1, e, post, i);
        node.left = constructBTUtil(in, s, r-1, post, i);
        return node;
    }

    private static int getIndex(int[] in, int s, int e, int root) {
        for (int i = s ; i <= e ; i++ ) {
            if(in[i] == root) {
                return i;
            }
        }

        return -1;
    }

    private static void testSample() {
        int[] in = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
        int[] post = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
        constructBT(in,post);
    }

    private static void testOne() {
        constructBT(new int[]{1}, new int[]{1});
    }

    private static void testNull() {
        constructBT(null, null);
    }

    private static void testTwo() {
        constructBT(new int[]{2,1}, new int[]{2,1});
    }

    private static void testThree() {
        constructBT(new int[]{2,1,3}, new int[]{2,3,1});
    }
}
