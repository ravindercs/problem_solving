/**
 * Created by ravinderk on 7/22/2016.
 */
public class LLSwapKthNodes {
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
        swapKth(null,2);
    }

    private static void testOne() {
        printList(swapKth(new Node(1),1));
    }

    private static void testTwo() {
        Node l = new Node(1);
        l = addNode(l, new Node(2));
        printList(l);
        printList(swapKth(l,1));
    }


    private static void testSample() {
        Node first = getLLFromArray(new int[]{1,30,3,9,2,240,51});
        printList(first);
        printList(swapKth(first,3));
    }

    private static void testSample2() {
        Node first = getLLFromArray(new int[]{5,20,4,30,3});
        printList(first);
        printList(swapKth(first,5));
    }

    private static void testSample3() {
        Node first = getLLFromArray(new int[]{8,7,3,4,5,6,1,2,9});
        printList(first);
        printList(swapKth(first,5));
    }

    private static Node swapKth(Node head, int k) {
        if(head == null || head.next == null) return head;

        Node x_prev = null;
        Node cur = head;
        int i = 1;
        while (cur != null && i < k ) {
            x_prev = cur;
            cur = cur.next;
            i++;
        }

        if(cur == null) { // No swap needed
            return head;
        }

        Node x = cur;

        Node y = head;
        Node y_prev = null;
        while (cur.next != null) {
            cur = cur.next;
            y_prev = y;
            y = y.next;
        }

        if(x_prev == null) {//first node
            if(x.next == y) {
                head = y;
                y.next = x;
                x.next = null;
            } else {
                cur = head;
                head = y;
                y.next = cur.next;
                cur.next = null;
                y_prev.next = cur;
            }
        } else if(y_prev == null) {
            cur.next = y.next ;
            head = cur;
            x_prev.next = y;
            y.next = null;
        } else if(y_prev == cur) {
            x_prev.next = y;
            cur.next = y.next;
            y.next = cur;
        } else {
            Node temp = x.next;
            x_prev.next = y;
            x.next = y.next;
            y.next = temp;
            y_prev.next = x;
        }

        return head;
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
