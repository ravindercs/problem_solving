/**
 * Created by ravinderk on 7/28/2016.
 */
public class LList {
    Node head;

    public LList(Node head) {
        this.head = head;
    }

    public Node addNodeAtLast(Node newNode) {
        return addNodeAtLast(head, newNode);
    }

    public Node addNodeAtLast(int data) {
        return addNodeAtLast(head, new Node(data));
    }

    private Node addNodeAtLast(Node head, Node newNode) {
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

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int size() {
        int size = 0;
        Node cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        return size;
    }

    public void printList() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.i+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void reverse() {
        if (head == null || head.next == null) return ;
        //reverse list
        Node cur = head;
        Node prev = null;
        Node next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        head = prev;
    }

}
