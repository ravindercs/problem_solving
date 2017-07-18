package com.ood.di;

/**
 * Created by ravinderk on 6/7/2017.
 */
public class BTConstructor {
    static class Index {
        int index;
    }

    public static void main(String[] args) {
        int[] in = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
        int[] post = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
        printTree(construct(in, post));
    }

    public static Node construct(int[] in, int[] post) {
        Index index = new Index();
        index.index = post.length - 1;
        return construct(in, post, 0, in.length - 1, index);
    }
    /*
    1. Take rightmost from post
    2. Create Root
    3. Recur for left and right
    4. Set child nodes
    5. Return root;
     */
    static Node construct(int[] in, int[] post, int il, int ir, Index index) {
        /*
        int[] in   = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
        int[] post   = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
         */
        if (il > ir) {
            return null;
        }


        Node root = new Node(post[index.index]);
        index.index -= 1;

        if (il == ir) return root;

        int ini = getInIndex(in, il, ir, root.data);

        if (ini < 0) throw new IllegalStateException("Invalid Input");

        root.right = construct(in, post, ini + 1, ir, index);
        root.left = construct(in, post, il, ini - 1, index);

        return root;
    }

    private static int getInIndex(int[] in, int il, int ir, int root) {
        for (int i = il; i <= ir; i++) {
            if (in[i] == root) {
                return i;
            }
        }
        return -1;
    }

    private static void printTree(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            printTree(root.left);
            printTree(root.right);
        }
    }

    /*
		    7
          /    \
        4        9
       / \      /  \
      2   5    8    10
     / \   \          \
    1   3   6         11
	pre = [7,4,2,1,3,5,6,9,8,10,11]
	1. Take first ele and create root
	2. Find sub arr smaller than root and bigger than root
	3. For left : recur on smaller subarr
	4. For right : recur on bigger subarr
	5. Return root
     */
    public static Node constructBSTFromPreOrder(int[] pre) {
        if (pre == null || pre.length == 0) return null;
        return constructBSTFromPreOrder(pre, 0, pre.length - 1);
    }

    public static Node constructBSTFromPreOrder(int[] pre, int l, int r) {
        if(l <=r) {
            Node root = new Node(pre[l]);
            if(l == r) return root;

            int i  = l+1;
            while (i<=r) {
                if(pre[i] < root.data) i++;
                else break;
            }
            root.left = constructBSTFromPreOrder(pre, l+1, i-1);
            root.right = constructBSTFromPreOrder(pre, i, r);
            return root;
        }
        return null;
    }
}