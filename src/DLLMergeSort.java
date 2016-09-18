/**
 * Created by ravinderk on 7/21/2016.
 */
public class DLLMergeSort {
    static class DLLNode {
        int i ;
        DLLNode next, prev;
        public DLLNode(int i) {
            this.i = i;
        }
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

    public static void main(String[] args){
        testNull();
        testOne();
        testTwo();
        testOdd();
        testEven();
    }

    private static void testNull() {
        printList(mergeSort(null));
    }

    private static void testOne() {
        DLLNode l = new DLLNode(5);
        printList(mergeSort(l));
    }

    private static void testTwo() {
        DLLNode l = new DLLNode(15);
        l = addNode(l, new DLLNode(10));
        printList(l);
        printList(mergeSort(l));
    }

    private static void testOdd() {
        DLLNode l = new DLLNode(5);
        l = addNode(l, new DLLNode(10));
        l = addNode(l, new DLLNode(7));
        l = addNode(l, new DLLNode(40));
        l = addNode(l, new DLLNode(4));
        printList(l);
        printList(mergeSort(l));
    }

    private static void testEven() {
        DLLNode l = new DLLNode(10);
        l = addNode(l, new DLLNode(8));
        l = addNode(l, new DLLNode(4));
        l = addNode(l, new DLLNode(2));
        printList(l);
        printList(mergeSort(l));
    }

    private static DLLNode mergeSort(DLLNode head) {
        if(head == null || head.next == null) return head;
        DLLNode first = head;
        DLLNode second = splitList(head);
        first = mergeSort(first);
        second = mergeSort(second);
        return sortedMerge(first, second);
    }

    public static DLLNode sortedMerge(DLLNode first, DLLNode second) {
        if(first == null) return second;
        if(second == null) return first;
        DLLNode result = null;
        while (first != null && second != null) {
            if(first.i > second.i) {
                DLLNode temp = second.next;
                second.next = null;
                result = addNode(result, second);
                second = temp;
            } else {
                DLLNode temp = first.next;
                first.next = null;
                result = addNode(result, first);
                first = temp;
            }
        }

        while (first != null) {
            DLLNode temp = first.next;
            first.next = null;
            result = addNode(result, first);
            first = temp;
        }

        while (second != null) {
            DLLNode temp = second.next;
            second.next = null;
            result = addNode(result, second);
            second = temp;
        }
        return result;
    }

    private static DLLNode splitList(DLLNode head) {
        if(head == null) return null;
        DLLNode slow = head;
        DLLNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if(slow.prev != null) {
            slow.prev.next = null;
            slow.prev = null;
        }
        return slow;
    }

    private static void printList(DLLNode head) {
        while (head != null) {
            System.out.print(head.i+" ");
            head = head.next;
        }
        System.out.println();
    }
}
