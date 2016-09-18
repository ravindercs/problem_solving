/**
 * Created by ravinderk on 7/28/2016.
 */
public class LListDeleteNodeWithMaxRight {
    public static void main(String[] args) {
        testNull();
        testOneTrue();
        testTwoTrue();
        testThree();
        test1();
    }

    private static void testNull() {
        System.out.println("--------Test Null--------");
        deleteNodeWithMaxRight(null);
    }

    private static void testOneTrue() {
        System.out.println("--------Test One True--------");
        Node one = new Node(1);
        deleteNodeWithMaxRight(one);
    }

    private static void testTwoTrue() {
        System.out.println("--------Test Two True--------");
        Node head = new Node(1);
        head.next = new Node(2);
        deleteNodeWithMaxRight(head);
    }

    private static void testThree() {
        System.out.println("--------Test Three True--------");
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        deleteNodeWithMaxRight(head);
    }

    private static void test1() {
        System.out.println("--------Test 1--------");
        LList lList = new LList(new Node(12));
        lList.addNodeAtLast(15);
        lList.addNodeAtLast(10);
        lList.addNodeAtLast(11);
        lList.addNodeAtLast(5);
        lList.addNodeAtLast(6);
        lList.addNodeAtLast(2);
        lList.addNodeAtLast(3);

        deleteNodeWithMaxRight(lList.getHead());
    }

    private static Node deleteNodeWithMaxRight(Node head) {
        if(head == null || head.next == null) return head;

        LList list = new LList(head);
        list.reverse();
        int max = list.head.i;
        Node cur = list.head;
        Node prev = null;

        while (cur != null) {
            if(max > cur.i) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                max = cur.i;
                prev = cur;
                cur = cur.next;
            }
        }

        list.reverse();
        list.printList();
        return list.head;
    }
}
