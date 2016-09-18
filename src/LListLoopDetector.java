import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ravinderk on 7/28/2016.
 */
public class LListLoopDetector {
    public static void main(String[] args) {
        testNull();
        testOneTrue();
        testOneFalse();
        testTwoTrue();
        testTwoFalse();
        testThree();
        test1();
    }

    private static void testNull() {
        System.out.println("--------Test Null--------");
        System.out.println(detectAndRemoveLoop(null));
    }

    private static void testOneTrue() {
        System.out.println("--------Test One True--------");
        Node one = new Node(1);
        one.next = one;
        System.out.println(detectAndRemoveLoop(one));
        new LList(one).printList();
    }

    private static void testOneFalse() {
        System.out.println("--------Test One False--------");
        System.out.println(detectAndRemoveLoop(new Node(1)));
    }

    private static void testTwoFalse() {
        System.out.println("--------Test Two False--------");
        Node head = new Node(1);
        head.next = new Node(2);
        System.out.println(detectAndRemoveLoop(head));
        new LList(head).printList();
    }

    private static void testTwoTrue() {
        System.out.println("--------Test Two True--------");
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = head.next;
        System.out.println(detectAndRemoveLoop(head));
        new LList(head).printList();
    }

    private static void testThree() {
        System.out.println("--------Test Three True--------");
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;
        System.out.println(detectAndRemoveLoop(head));
        new LList(head).printList();
    }

    private static void test1() {
        System.out.println("--------Test 1--------");
        LList lList = new LList(new Node(1));
        lList.addNodeAtLast(2);
        lList.addNodeAtLast(3);
        lList.addNodeAtLast(4);
        lList.addNodeAtLast(5);
        lList.addNodeAtLast(6);
        lList.addNodeAtLast(7);
        lList.addNodeAtLast(8);

        lList.head.next.next.next.next.next.next.next.next = lList.head.next.next;

        System.out.println(detectAndRemoveLoop(lList.getHead()));
        lList.printList();
    }
/*
1->2->3->4->5
      |     |
      8<-7<-6
 */
    private static boolean detectAndRemoveLoop2(Node head) {
        Set<Node> s = new HashSet<Node>();
        Node prev = null;
        boolean res = false;
        while (head != null) {
            if(s.contains(head)) {
                res = true;
                break;
            } else {
                s.add(head);
            }
            prev = head;
            head = head.next;
        }

        if(res) {
            prev.next = null;
        }

        return res;
    }

    private static boolean detectAndRemoveLoop(Node head) {
        if(head == null || head.next == null) return false;
        Node slow = head;
        Node fast = head.next;
        boolean res = false;

        while (fast != null && fast.next != null) {
            if(slow == fast) {
                res = true;
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        if(res) {
            Node y = slow.next;
            slow.next = null;
            if(y.next != null && y != head) {
                LList one = new LList(head);
                Node second = one.head;
                LList two = new LList(y);
                int lo = one.size();
                int lt = two.size();
                if (lo > lt) {
                    int c = lt - lo;
                    while (c-- > 0) {
                        one.head = one.head.next;
                    }
                } else {
                    int c = lo - lt;
                    while (c-- > 0) {
                        two.head = two.head.next;
                    }
                }

                Node prev = null;
                while (one.head != null && two.head != null && one.head != two.head) {
                    prev = two.head;
                    one.head = one.head.next;
                    two.head = two.head.next;
                }
                if (prev != null) {
                    prev.next = null;
                }
                slow.next = y;
            }
        }

        return res;
    }
}
