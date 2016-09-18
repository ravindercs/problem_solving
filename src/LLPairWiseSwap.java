/**
 * Created by ravinderk on 7/22/2016.
 */
public class LLPairWiseSwap {
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
        testSample();
        testSample2();
        testSample3();
    }

    private static void testNull() {
        pairWiseSwap(null);
    }

    private static void testOne() {
        printList(pairWiseSwap(new Node(1)));
    }

    private static void testTwo() {
        Node l = new Node(1);
        l = addNode(l, new Node(2));
        printList(pairWiseSwap(l));
    }


    private static void testSample() {
        Node first = getLLFromArray(new int[]{1,3,30,90,120,240,511});
        printList(pairWiseSwap(first));
    }

    private static void testSample2() {
        Node first = getLLFromArray(new int[]{1,2,3,4,5,6,7});
        printList(pairWiseSwap(first));
    }

    private static void testSample3() {
        Node first = getLLFromArray(new int[]{1,2,3,4,5,6,7,8});
        printList(pairWiseSwap(first));
    }

    private static Node pairWiseSwap(Node head) {
        if(head == null || head.next == null) return head;

        Node result = null;
        Node cur = head;
        Node prev = null;
        while (cur != null && cur.next != null) {
            Node nextCur = cur.next;
            Node nextNextCur = nextCur.next;
            nextCur.next = cur;
            cur.next = nextNextCur;
            if(result == null) {
                result = nextCur;
                prev = cur;
            } else {
                prev.next = nextCur;
                prev = cur;
            }
            cur = nextNextCur;
        }

        return result;
    }


    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.i +" ");
            head = head.next;
        }
        System.out.println();
    }

    private static Node getLLFromArray(int[] a) {
        Node result = null;
        for (int i = 0 ; i < a.length; i++) {
            result = addNode(result, new Node(a[i]));
        }
        return result;
    }
}
