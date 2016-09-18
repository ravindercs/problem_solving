/**
 * Created by ravinderk on 7/22/2016.
 */
public class LLQSort {
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
        qSort(null);
    }

    private static void testOne() {
        printList(qSort(new Node(1)));
    }

    private static void testTwo() {
        Node l = new Node(1);
        l = addNode(l, new Node(2));
        printList(qSort(l));
    }


    private static void testSample() {
        Node first = getLLFromArray(new int[]{1,30,3,9,2,240,51});
        printList(qSort(first));
    }

    private static void testSample2() {
        Node first = getLLFromArray(new int[]{5,20,4,30,3});
        printList(qSort(first));
    }

    private static void testSample3() {
        Node first = getLLFromArray(new int[]{8,7,3,4,5,6,1,2});
        printList(qSort(first));
    }

    private static Node qSort(Node head) {
        if(head == null || head.next == null) return head;
        Node pivot = head;
        head = head.next;
        pivot.next = null;
        Node[] parts = partition(head, pivot) ;
        parts[0] = qSort(parts[0]);
        parts[1] = qSort(parts[1]);
        parts[0] = addNode(parts[0], pivot);
        return sortedMerge(parts[0],parts[1]);
    }

    public static Node sortedMerge(Node first, Node second) {
        if(first == null) return second;
        if(second == null) return first;
        Node result = null;
        while (first != null && second != null) {
            if(first.i > second.i) {
                Node temp = second.next;
                second.next = null;
                result = addNode(result, second);
                second = temp;
            } else {
                Node temp = first.next;
                first.next = null;
                result = addNode(result, first);
                first = temp;
            }
        }

        while (first != null) {
            Node temp = first.next;
            first.next = null;
            result = addNode(result, first);
            first = temp;
        }

        while (second != null) {
            Node temp = second.next;
            second.next = null;
            result = addNode(result, second);
            second = temp;
        }
        return result;
    }

    private static Node[] partition(Node head, Node pivot) {
        Node[] parts = new Node[2];
        while (head != null) {
            if(head.i < pivot.i) {
                parts[0] = addNode(parts[0], head);
            } else {
                parts[1] = addNode(parts[1], head);
            }
            Node temp = head.next;
            head.next = null;
            head = temp;
        }
        return parts;
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
