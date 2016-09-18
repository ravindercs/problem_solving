/**
 * Created by ravinderk on 7/23/2016.
 */
public class TernaryTree {
    static class TTNode {
        int data ;
        TTNode left, middle, right;

        public TTNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        TTList list = new TTList(null);
        getLLFromTTree(getTTree(), list);
        printList(list.head);
    }

    static class TTList {
        TTNode head;
        TTNode tail;

        public TTList(TTNode head) {
            this.head = head;
        }

        public void push(TTNode node) {
            if(head == null) {
                head = node;
                tail = node;
            } else {
                tail.right = node;
                node.left = tail;
                tail = node;
            }
        }
    }

    private static void getLLFromTTree(TTNode root, TTList list) {
        if(root == null) return ;
        TTNode left = root.left;
        TTNode middle = root.middle;
        TTNode right = root.right;

        root.middle = null;
        list.push(root);

        getLLFromTTree(left, list);
        getLLFromTTree(middle, list);
        getLLFromTTree(right, list);
    }

    private static void printList(TTNode list) {
        while (list != null) {
            System.out.print(list.data+" ");
            list = list.right;
        }
        System.out.println();
    }

    private static TTNode getTTree() {
        TTNode root = new TTNode(30);
        root.left = new TTNode(5);
        root.middle = new TTNode(11);
        root.right = new TTNode(63);

        root.left.left = new TTNode(1);
        root.left.middle = new TTNode(4);
        root.left.right = new TTNode(8);

        root.middle.left = new TTNode(6);
        root.middle.middle = new TTNode(7);
        root.middle.right = new TTNode(15);

        root.right.left = new TTNode(31);
        root.right.middle = new TTNode(55);
        root.right.right = new TTNode(65);

        return root;
    }
}
