import java.util.*;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class ArbitMaxPtr {
    static class  Node {
        int d ;
        Node next;
        Node arbit;

        public Node(int d) {
            this.d = d;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        Stack<Node> stack = new Stack<Node>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        Node max = stack.pop();
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            node.arbit = max;
            if(max.d < node.d) {
                max = node;
            }
        }

        cur = head;
        while (cur != null) {
            System.out.println(cur.d + " " + (cur.next != null ? cur.next.d : null)+" "+(cur.arbit != null ? cur.arbit.d : null));
            cur = cur.next;
        }
    }
}