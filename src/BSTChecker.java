package com.ood.di;

/**
 * Created by ravinderk on 6/8/2017.
 */
/*
If if BST:

1. All elements in left should be smaller than node
2. All elements in right of node should be bigger that node

Overvations:
1. BST: Inorder is sorted
2. Do inorder with checking prev.

Solution:
1. MAX of left subtree should be smaller than node
2. Min of right subtree should be greater than node

What is the max of a tree. Right most ?
What is the min of a tree. Left most ?

Which order we should travel to calculate the info. Post Order because I need info from sub tree
{
if (root == null) return true;

if(isLeaf(root)) return true;

if(isBST(root.left) && isBST(root.right) ) {
	return root.data > maxOfBT(root.left) && root.data < minOfBT(root.right);
}

return false;
}

maxOfBT(Node root) {
	if(root == null) return 0;
	Node cur = root.left;
	int max = root.data;
	while(cur != null) {
		if(max < cur.data) max = cur.data;
		cur = cur.left;
	}
	return max;
}

minOfBT(Node root) {
	if(root == null) return 0;
	Node cur = root.right;
	int max = root.data;
	while(cur != null) {
		if(max < cur.data) max = cur.data;
		cur = cur.right;
	}
	return max;
}
 */
public class BSTChecker {
    public static void main(String[] args) {
        Node root = BTConstructor.constructBSTFromPreOrder(new int[]{2,1,3});
        System.out.println(checkIfBST(root));

        root = BTConstructor.constructBSTFromPreOrder(new int[]{1,2,3});
        System.out.println(checkIfBST(root));

        int[] in = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
        int[] post = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
        BTConstructor.Index index = new BTConstructor.Index();
        index.index = post.length - 1;
        root = BTConstructor.construct(in, post, 0, in.length - 1, index);
        System.out.println(checkIfBST(root));
    }

    private static boolean checkIfBST(Node root) {
        return checkIfBST(root, new NodeHolder());
    }

    private static boolean checkIfBST(Node root, NodeHolder prev) {
        if(root != null) {
            if (!checkIfBST(root.left, prev)) return false;

            if(prev.node != null && prev.node.data >= root.data)  return false;

            prev.node = root;

            return checkIfBST(root.right, prev);
        }
        return true;
    }
}
