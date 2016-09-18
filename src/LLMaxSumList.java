/**
 * Created by ravinderk on 7/22/2016.
 */
public class LLMaxSumList {
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
        testTwoSame();
        testSample();
    }

    private static void testNull() {
        getMaxSumList(null, null);
    }

    private static void testOne() {
        printList(getMaxSumList(new Node(1), null));
    }

    private static void testTwo() {
        printList(getMaxSumList(new Node(1), new Node(2)));
    }

    private static void testTwoSame() {
        printList(getMaxSumList(new Node(1), new Node(1)));
    }


    private static void testSample() {
        Node first = getLLFromArray(new int[]{1,3,30,90,120,240,511});
        Node second = getLLFromArray(new int[]{0,3,12,32,90,125,240,249});
        printList(getMaxSumList(first, second));
    }

    private static Node getMaxSumList(Node first, Node second) {
        if(first == null) return second;
        if(second == null) return first;
        Node result = null;

        while (first != null && second != null) {
            int fsum = 0;
            int ssum = 0;
            Node f = null;
            Node s = null;
            while (first != null && second != null) {
                if(first.i < second.i) {
                    fsum += first.i;
                    f = addNode(f, new Node(first.i));
                    first = first.next;
                } else if(second.i < first.i) {
                    ssum +=  second.i;
                    s = addNode(s, new Node(second.i));
                    second = second.next;
                } else {
                    fsum += first.i;
                    ssum += second.i;
                    f = addNode(f, new Node(first.i));
                    s = addNode(s, new Node(second.i));
                    break;
                }
            }

            if(first != null && second == null) {
                while (first != null) {
                    fsum += first.i;
                    f = addNode(f, new Node(first.i));
                    first = first.next;
                }
            }

            if(second != null && first == null) {
                while (second != null) {
                    ssum += second.i;
                    s = addNode(s, new Node(second.i));
                    second = second.next;
                }
            }

            if (fsum >= ssum) {
                result = addNode(result, f);
            } else {
                result = addNode(result, s);
            }

            if(first != null) {
                first = first.next;
            }
            if(second != null) {
                second = second.next;
            }
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
