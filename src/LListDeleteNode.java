/**
 * Created by ravinderk on 7/28/2016.
 */
public class LListDeleteNode {
    public static void main(String[] args) {
        testNull();
        //testOneTrue();
        //testOneFalse();
        testTwo();
        testThree();
        test1();
    }

    private static void testNull() {
        deleteNode(null, 1);
    }

    private static void testOneTrue() {
        deleteNode(new Node(1), 1);
    }

    private static void testOneFalse() {
        deleteNode(new Node(1), 2);
    }

    private static void testTwo() {
        LList list = new LList(new Node(1));
        list.addNodeAtLast(2);
        deleteNode(list.getHead(), 1);
    }

    private static void testThree() {
        LList list = new LList(new Node(1));
        list.addNodeAtLast(2);
        list.addNodeAtLast(3);
        deleteNode(list.getHead(), 2);
    }

    private static void test1() {
        LList lList = new LList(new Node(1));
        lList.addNodeAtLast(2);
        lList.addNodeAtLast(3);
        lList.addNodeAtLast(4);
        lList.addNodeAtLast(5);
        lList.addNodeAtLast(6);
        lList.addNodeAtLast(7);

        deleteNode(lList.getHead(), 3);
    }

    private static void deleteNode(Node head, int data) {
        if(head == null) return;

        if(head.i == data) {
            //Copy second node data to head node
            //delete second node data
            if(head.next == null) {
                throw new IllegalArgumentException("Can't delete only head node");
            }
            head.i = head.next.i;
            head.next = head.next.next;
            return;
            //Deleting will be done by GC
        }

        while (head.next != null && head.next.i != data) {
            head = head.next;
        }

        if(head.next == null) {
            throw new IllegalArgumentException("Node to be deleted not found");
        }

        head.next = head.next.next;

        return;
    }
}
