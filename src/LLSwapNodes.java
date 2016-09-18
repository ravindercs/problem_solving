/**
 * Created by ravinderk on 7/22/2016.
 */
public class LLSwapNodes {

    public static void main(String[] args){
        testNull();
        testOne();
        testTwo();
        testEven();
        testHead();
        testTail();
    }

    private static void testNull() {
        printList(swapNodes(null,1,2));
    }

    private static void testOne() {
        printList(swapNodes(new Node(1),1,2));
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

    private static void testTwo() {
        Node l = new Node(1);
        l = addNode(l,new Node(2));
        printList(swapNodes(l,1,2));
    }

    private static void testEven() {
        Node head = new Node(2);
        head = addNode(head, new Node(3));
        printList(swapNodes(head, 1,2));
    }

    private static void testHead() {
        Node l = new Node(5);
        l = addNode(l, new Node(10));
        l = addNode(l, new Node(15));
        l = addNode(l, new Node(40));

        printList(swapNodes(l,5,15));
    }

    private static void testTail() {
        Node l = new Node(5);
        l = addNode(l, new Node(10));
        l = addNode(l, new Node(15));
        l = addNode(l, new Node(40));

        printList(swapNodes(l,5,40));
    }

    private static Node swapNodes(Node head, int i, int j) {
        if(head == null || head.next == null) return head;
        if(i == j) return head;

        Node pi = null, ni = head;
        Node pj = null, nj = head;

        while (ni != null && ni.i != i) {
            pi = ni;
            ni = ni.next;
        }

        while (nj != null && nj.i != j) {
            pj = nj;
            nj = nj.next;
        }

        if(ni == null || nj == null)
            return head;

        if(pi != null) {
            pi.next = nj;
        } else {
            head = nj;
        }

        if(pj != null) {
            pj.next = ni;
        } else {
            head = ni;
        }

        Node temp = ni.next;
        ni.next = nj.next;
        nj.next = temp;

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
