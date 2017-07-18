package com.ood.di;

/**
 * Created by ravinderk on 6/11/2017.
 */
public class FoldableBT {
    public static void main(String[] args) {
        int[] in = new int[]{7,9,10,11,15};
        int[] post = new int[]{9,7,11,15,10};
        Node root = BTConstructor.construct(in, post);
        BinaryTreeUtils.printLevelOrder(root);
        System.out.println("Foldable : "+isFoldable(root));
        System.out.println("Foldable : "+isFoldableWithMirror(root));

        in = new int[]{9,7,10,15,11};
        post = new int[]{9,7,11,15,10};
        root = BTConstructor.construct(in,post);
        BinaryTreeUtils.printLevelOrder(root);
        System.out.println("Foldable : "+isFoldable(root));
        System.out.println("Foldable : "+isFoldableWithMirror(root));

        in = new int[]{5,7,10,11,15};
        post = new int[]{5,7,11,15,10};
        root = BTConstructor.construct(in, post);
        BinaryTreeUtils.printLevelOrder(root);
        System.out.println("Foldable : "+isFoldable(root));
        System.out.println("Foldable : "+isFoldableWithMirror(root));

        in = new int[]{9,7,8,10,12,15};
        post = new int[]{9,8,7,12,15,10};
        root = BTConstructor.construct(in, post);
        BinaryTreeUtils.printLevelOrder(root);
        System.out.println("Foldable : "+isFoldable(root));
        System.out.println("Foldable : "+isFoldableWithMirror(root));
    }

    public static boolean isFoldable(Node root){
        return root == null || isFoldable(root.left, root.right);
    }

    private static boolean isFoldable(Node l, Node r) {
        if ( l == null  && r == null) return true;
        if ( l == null  || r == null) return false;
        return isFoldable(l.left, r.right) && isFoldable(l.right, r.left);
    }

    private static boolean isFoldableWithMirror(Node root) {
        if(root != null) return true;
        BinaryTreeUtils.mirror(root.left);

        boolean result = BinaryTreeUtils.isSameStruct(root.left, root.right);

        BinaryTreeUtils.mirror(root.left);

        return result;
    }
}
