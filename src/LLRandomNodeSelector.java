import java.util.UUID;

/**
 * Created by ravinderk on 7/21/2016.
 */
public class LLRandomNodeSelector {
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
        testOdd();
    }

    private static void testOdd() {
        Node l = new Node(5);
        l = addNode(l, new Node(10));
        l = addNode(l, new Node(15));
        l = addNode(l, new Node(40));
        l = addNode(l, new Node(4));

        findRandomNode(l);
    }

    private static void findRandomNode(Node head) {
        if(head == null) return;

        Math.abs(UUID.randomUUID().getMostSignificantBits());

        Node result = head;
        Node cur = head;
        int i = 2;
        for (; cur != null; i++) {
            System.out.println((int)(100*Math.random()) % i);
            if((100*Math.random()) % i == 0) {
                result = head;
            }
            cur = cur.next;
        }

        System.out.println(result.i);
    }

    private static Node getKthNode(Node head, int k) {
        int i = 0 ;
        while (i < k) {
            head = head.next;
            i++;
        }
        if(head != null) {
            return head;
        }
        return null;
    }
    private static int countNodes(Node head) {
        int i = 0 ;
        while (head != null) {
            i++;
            head = head.next;
        }
        return i;
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
