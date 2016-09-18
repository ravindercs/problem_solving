/**
 * Created by ravinderk on 7/21/2016.
 */
public class DoublyLinkedList {
    DLLNode head;

    DoublyLinkedList(int i) {
        head = new DLLNode(i);
    }

    public DLLNode addNode(int i) {
        return addNode(head,new DLLNode(i));
    }

    private static DLLNode addNode(DLLNode head, DLLNode newNode) {
        DLLNode cur = head;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }
        if(cur == null) {
            head = newNode;
        } else {
            cur.next = newNode;
            newNode.prev = cur;
        }
        return head;
    }

    public void printList() {
        DLLNode cur = head;
        while (cur != null) {
            System.out.print(cur.i+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void reverse() {
        DLLNode cur = head;
        DLLNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = cur.prev;
            cur.prev = temp;
            head = cur;
            cur = temp;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList ll = new DoublyLinkedList(1);
        ll.addNode(2);
        ll.addNode(3);
        ll.addNode(4);
        ll.addNode(5);
        ll.printList();
        ll.reverse();
        ll.printList();
    }
}
