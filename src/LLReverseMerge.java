/**
 * Created by ravinderk on 7/21/2016.
 */
public class LLReverseMerge {
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
        printList(reverseMerge(null,null));
    }

    private static void testOne() {
        printList(reverseMerge(new Node(1),null));
    }

    private static void testTwo() {
        printList(reverseMerge(null, new Node(2)));
    }

    private static void testEven() {
        Node head = new Node(2);
        head = addNode(head, new Node(3));
        head = addNode(head, new Node(20));
        printList(reverseMerge(null, head));
    }

    private static void testOdd() {
        Node l = new Node(5);
        l = addNode(l, new Node(10));
        l = addNode(l, new Node(15));
        l = addNode(l, new Node(40));

        Node r = new Node(2);
        r = addNode(r, new Node(3));
        r = addNode(r, new Node(20));

        printList(reverseMerge(l,r));
    }

    private static Node reverseMerge(Node l, Node r) {
        Node head = null;
        while (l != null && r != null) {
            if(l.i < r.i) {
                Node temp = l.next;
                l.next = null;
                head = addInFront(head,l);
                l = temp;
            } else {
                Node temp = r.next;
                r.next = null;
                head = addInFront(head,r);
                r = temp;
            }
        }

        while (l != null) {
            Node temp = l.next;
            l.next = null;
            head = addInFront(head,l);
            l = temp;
        }

        while (r != null) {
            Node temp = r.next;
            r.next = null;
            head = addInFront(head,r);
            r = temp;
        }

        return head;
    }

    private static Node addInFront(Node head, Node newNode) {
        newNode.next = head;
        return newNode;
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.i+" ");
            head = head.next;
        }
        System.out.println();
    }
}
