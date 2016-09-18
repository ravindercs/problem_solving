/**
 * Created by ravinderk on 7/21/2016.
 */
public class LLCollectOddEvenNodes {
    static class Node {
        int i ;
        Node next;

        public Node(int i) {
            this.i = i;
        }
    }

    private static Node addNode(Node head, Node newNode) {
        Node cur = head;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }
        if(cur == null) {
            head = newNode;
        } else {
            cur.next = newNode;
        }
        return head;
    }

    public static void main(String[] args){
        testNull();
        testOne();
        testTwo();
        testEven();
        testOdd();
    }

    private static void testNull() {
        printList(rarrangeOddEvenNodes(null));
    }

    private static void testOne() {
        printList(rarrangeOddEvenNodes(new Node(1)));
    }

    private static void testTwo() {
        Node head = new Node(1);
        head = addNode(head, new Node(2));
        printList(rarrangeOddEvenNodes(head));
    }

    private static void testEven() {
        Node head = new Node(1);
        head = addNode(head, new Node(2));
        head = addNode(head, new Node(3));
        head = addNode(head, new Node(4));
        printList(rarrangeOddEvenNodes(head));
    }

    private static void testOdd() {
        Node head = new Node(1);
        head = addNode(head, new Node(2));
        head = addNode(head, new Node(3));
        head = addNode(head, new Node(4));
        head = addNode(head, new Node(5));
        head = rarrangeOddEvenNodes(head);
        printList(head);
    }

    private static Node rarrangeOddEvenNodes(Node head) {
        Node odd = null;
        Node even = null;
        Node cur = head;
        while (cur != null) {
            Node temp = cur.next;
            cur.next = null;
            odd = addNode(odd, cur);
            cur = temp;
            if(cur != null) {
                temp = cur.next;
                cur.next = null;
                even = addNode(even, cur);
                cur = temp;
            }
        }

        if(odd != null) {
            odd = addNode(odd, even);
        }
        return odd;
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.i+" ");
            head = head.next;
        }
        System.out.println();
    }
}
