/**
 * Created by ravinderk on 7/22/2016.
 */
public class LLRemoveMiddlePointsInLine {
    static class Node {
        int x,y ;
        Node next;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
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
        testEven();
        testHorizontal();
        testVertical();
        testPoints();
        testZigZag();
    }

    private static void testNull() {
        removeMiddlePoints(null);
    }

    private static void testOne() {
        Node l = new Node(1,0);
        removeMiddlePoints(l);
        printList(l);
    }

    private static void testTwo() {
        Node l = new Node(1,0);
        l = addNode(l,new Node(2,0));
        printList(l);
        removeMiddlePoints(l);
        printList(l);
    }

    private static void testEven() {
        Node head = new Node(2,0);
        head = addNode(head, new Node(3,1));
        printList(head);
        removeMiddlePoints(head);
        printList(head);
    }

    private static void testHorizontal() {
        Node l = new Node(0,10);
        l = addNode(l, new Node(1,10));
        l = addNode(l, new Node(5,10));
        l = addNode(l, new Node(7,10));
        l = addNode(l, new Node(7,5));
        l = addNode(l, new Node(20,5));
        l = addNode(l, new Node(40,5));
        printList(l);
        removeMiddlePoints(l);
        printList(l);
    }

    private static void testVertical() {
        Node l = new Node(0,10);
        l = addNode(l, new Node(1,10));
        l = addNode(l, new Node(5,10));
        l = addNode(l, new Node(7,10));
        l = addNode(l, new Node(7,8));
        l = addNode(l, new Node(7,6));
        l = addNode(l, new Node(7,5));
        l = addNode(l, new Node(20,5));
        l = addNode(l, new Node(40,5));
        printList(l);
        removeMiddlePoints(l);
        printList(l);
    }

    private static void testPoints() {
        Node l = new Node(0,10);
        l = addNode(l, new Node(7,10));
        l = addNode(l, new Node(7,5));
        l = addNode(l, new Node(40,5));
        printList(l);
        removeMiddlePoints(l);
        printList(l);
    }

    private static void testZigZag() {
        Node l = new Node(0,10);
        l = addNode(l, new Node(7,9));
        l = addNode(l, new Node(6,5));
        l = addNode(l, new Node(10,8));
        printList(l);
        removeMiddlePoints(l);
        printList(l);
    }

    private static void removeMiddlePoints(Node head) {
        while (head != null && head.next != null && head.next.next != null) {
            if(head.x == head.next.x && head.x == head.next.next.x && head.y != head.next.y) {//verticle line
                head.next = head.next.next;
            } else if(head.y == head.next.y && head.y == head.next.next.y && head.x != head.next.x) {//horizontal line
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
    }


    private static void printList(Node head) {
        while (head != null) {
            System.out.print("("+head.x+", "+head.y+")->");
            head = head.next;
        }
        System.out.println();
    }
}
