import java.util.Scanner;

/**
 * Created by ravinderk on 6/28/2016.
 */
public class RearrangeLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Node head = null;
        while (t > 0)
        {
            int n = sc.nextInt();
            Node curNode = head;
            for(int i = 0 ; i < n ; i++) {
                Node node = new Node(sc.nextInt());
                if(head == null) {
                    head = node;
                } else {
                    curNode.next = node;
                }
                curNode = node;
            }
            rearrangeList(head);
            printList(head);
            t--;
        }
    }

    private static void rearrangeList(Node head) {
        int size = 0;
        Node node = head;
        while (node != null) {
            node = node.next;
            size++;
        }

        Node cNode = head;
        for (int i = 0 ; i < (size-1)/2; i++) {
            cNode = cNode.next;
        }

        Node head2 = cNode.next;
        cNode.next = null;

        Node cur = head2,prev = null,next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        head2 = prev;

        cur = head;
        while (cur != null && head2 != null) {
            Node newHead2 = head2.next;
            Node newCur = cur.next;
            cur.next = head2;
            head2.next = newCur;
            head2 = newHead2;
            cur = newCur;
        }
    }

    private static void printList(Node head) {
        Node node = head;
        while(node != null) {
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }


}
