import java.util.*;

/**
 * Created by ravinderk on 7/24/2016.
 */
public class BTFromAncestorMatrix {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int mat[][] =  {{0, 0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 1, 0},
                        {0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0},
                        {1, 1, 1, 1, 1, 0}};

        BinarySearchTree bst = new BinarySearchTree();
        createBTFromAcenstorMatrix(mat, bst);
        bst.printLevelOrder();
        printMat(mat);
        System.out.println();
        createAncestorMatrixFromBT(bst);
        System.out.println();
        inOrder(bst.root);
        inOrder2(bst.root);
    }

    //i is ancestor of j
    //row with max ones is root
    //row with all zeros are leaf nodes
    // 2->3
    // 1->0, 1->4
    //      5
    //    1   2
    //  0  4    3
    private static void createBTFromAcenstorMatrix(int[][] mat, BinarySearchTree bst) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        for (int i = 0 ; i < mat.length; i++) {
            int sum = 0;
            for(int j = 0 ; j < mat[0].length; j++) {
                sum += mat[i][j];
            }

            List<Integer> list = map.get(sum);
            if(list == null) {
                list = new LinkedList<Integer>();
                map.put(sum, list);
            }
            list.add(i);
        }

        TNode[] nodes = new TNode[mat.length];
        TNode root = null;
        boolean[] parent = new boolean[mat.length];
        Set<Integer> sortedSum = new TreeSet<Integer>(map.keySet());
        for (Integer rsum : sortedSum) {
            List<Integer> list = map.get(rsum);
            for (Integer row : list) {
                nodes[row] = new TNode(row);
                root = nodes[row];
                if(rsum != null) {//Non-leaf
                    for (int j = 0; j < mat[0].length; j++) {
                        if (!parent[j] && mat[row][j] == 1) {
                            //Assuming that valid tree is possible
                            if (nodes[row].left == null) {
                                nodes[row].left = nodes[j];
                            } else {
                                nodes[row].right = nodes[j];
                            }
                            parent[j] = true;
                        }
                    }
                }
            }
        }

        bst.setRoot(root);
    }

    private static int[][] createAncestorMatrixFromBT(BinarySearchTree bt) {
        if(bt == null || bt.getRoot() == null) return null;
        int n = bt.getCount();
        int[][] mat = new int[n][n];
        Deque<TNode> ancestors = new LinkedList<TNode>();
        createBTFromAcenstorMatrix(bt.getRoot(), mat, ancestors);
        printMat(mat);
        return mat;
    }

    private static void printMat(int[][] mat) {
        for (int i = 0 ; i < mat.length; i++) {
            for (int j = 0 ; j < mat[0].length; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static void createBTFromAcenstorMatrix(TNode root, int[][] mat, Deque<TNode> ancestors) {
        if(root == null) return;
        for (TNode a : ancestors) {
            mat[a.i][root.i] = 1;
        }
        ancestors.addLast(root);
        createBTFromAcenstorMatrix(root.left, mat, ancestors);
        createBTFromAcenstorMatrix(root.right, mat, ancestors);
        ancestors.removeLast();
    }

    static class NData {
        TNode node;
        boolean isVisited;

        public NData(boolean isVisited, TNode node) {
            this.isVisited = isVisited;
            this.node = node;
        }
    }

    private static void inOrder(TNode root) {
        if(root == null) return;
        Stack<NData> stack = new Stack<NData>();
        stack.push(new NData(false, root));
        /*
        left root right

         */
        while (!stack.isEmpty()) {
            NData top = stack.peek();
            if(top.node.left != null && !top.isVisited) {
                top.isVisited = true;
                stack.push(new NData(false, top.node.left));
            } else {
                stack.pop();
                System.out.print(top.node.i +" ");

                if(top.node.right != null) {
                    stack.push(new NData(false, top.node.right));
                }
            }
        }
        System.out.println();
    }

    private static void inOrder2(TNode root) {
        if(root == null) return;
        Stack<TNode> stack = new Stack<TNode>();
        pushAllLeftNodes(stack, root);
        while (!stack.isEmpty()) {
            TNode top = stack.pop();
            System.out.print(top.i+" ");
            if(top.right != null) {
                top = top.right;
                pushAllLeftNodes(stack, top);
            }
        }
        System.out.println();
    }

    private static void pushAllLeftNodes(Stack<TNode> stack, TNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
