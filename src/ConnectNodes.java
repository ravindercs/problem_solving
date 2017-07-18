package com.ood.di;

/**
 * Created by ravinderk on 6/7/2017.
 */
// Java program to connect nodes at same level using extended
// pre-order traversal

// A binary tree node
public class ConnectNodes
{
    Node root;

    // Sets the nextRight of root and calls connectRecur() for other nodes
    void connect(Node p)
    {

        // Set the nextRight for root
        p.nextRight = null;

        // Set the next right for rest of the nodes (other than root)
        connectRecur(p);
        // Now fix the connect for incomplete BT
        connectFix(p);
    }

    private void connectFix(Node p) {
        if(p == null) return;

        if(p.left != null && p.left.nextRight == null) {
            p.left.nextRight = findNextRight(p);
        }

        if(p.right != null && p.right.nextRight == null) {
            p.right.nextRight = findNextRight(p);
        }

        connectFix(p.left);
        connectFix(p.right);
    }

    private Node findNextRight(Node root) {
        Node nextRight = null;
        Node p = root.nextRight;
        while (p != null) {
            if(p.left != null) {
                nextRight = p.left;
                break;
            }
            if(p.right != null) {
                nextRight = p.right;
                break;
            }

            p = p.nextRight;
        }
        return nextRight;
    }

    /* Set next right of all descendents of p.
    Assumption: p is a compete binary tree */
    void connectRecur(Node p)
    {
        // Base case
        if (p == null)
            return;

        // Set the nextRight pointer for p's left child
        if (p.left != null)
            p.left.nextRight = p.right;

        // Set the nextRight pointer for p's right child
        // p->nextRight will be NULL if p is the right most child
        // at its level
        if (p.right != null)
            p.right.nextRight = (p.nextRight != null) ?
                    p.nextRight.left : null;

        // Set nextRight for other nodes in pre order fashion
        connectRecur(p.left);
        connectRecur(p.right);
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        ConnectNodes tree = new ConnectNodes();

		/* Constructed binary tree is
		10
		/ \
		8   2
		/
		3
		*/
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);

        // Populates nextRight pointer in all nodes
        tree.connect(tree.root);

        // Let us check the values of nextRight pointers
        System.out.println("Following are populated nextRight pointers in "
                + "the tree" + "(-1 is printed if there is no nextRight)");
        int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.data + " is "
                + a);
        int b = tree.root.left.nextRight != null ?
                tree.root.left.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.left.data + " is "
                + b);
        int c = tree.root.right.nextRight != null ?
                tree.root.right.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.right.data + " is "
                + c);
        int d = tree.root.left.left.nextRight != null ?
                tree.root.left.left.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.left.left.data + " is "
                + d);

        test2();
    }

    private static void test2() {
        /*
		    1
          /    \
        2        3
       / \      /  \
      4   5    6    7
     / \           / \
    8   9        10   11
		 */
        ConnectNodes tree = new ConnectNodes();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.right.left = new Node(10);
        tree.root.right.right.right = new Node(11);

        // Populates nextRight pointer in all nodes
        tree.connect(tree.root);

        // Let us check the values of nextRight pointers
        System.out.println("Following are populated nextRight pointers in "
                + "the tree" + "(-1 is printed if there is no nextRight)");
        int a = tree.root.nextRight != null ? tree.root.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.data + " is "
                + a);
        int b = tree.root.left.nextRight != null ?
                tree.root.left.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.left.data + " is "
                + b);
        int c = tree.root.right.nextRight != null ?
                tree.root.right.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.right.data + " is "
                + c);
        int d = tree.root.left.left.nextRight != null ?
                tree.root.left.left.nextRight.data : -1;
        System.out.println("nextRight of " + tree.root.left.left.data + " is "
                + d);
        System.out.println("nextRight of " + tree.root.left.left.right.data + " is "
                + tree.root.left.left.right.nextRight.data);

    }

}

// This code has been contributed by Mayank Jaiswal

