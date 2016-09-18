import java.util.*;

public class BST2MinHeapConvertor {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(new TNode(8));
        bst.add(new TNode(4));
        bst.add(new TNode(2));
        bst.add(new TNode(6));
        bst.add(new TNode(12));
        bst.add(new TNode(10));
        bst.add(new TNode(14));

        MinHeap heap = new MinHeap();
        doInOrder(bst.getRoot(), heap);
        printList(heap.head);
        Queue<TNode> q = new LinkedList<TNode>();
        q.add(heap.head);
        TNode cur = heap.head.right;
        heap.head.left = null;
        heap.head.right = null;

        while (!q.isEmpty()) {
            TNode node = q.remove();
            if(cur == null) {
                node.left = null;
                node.right = null;
            } else {
                q.add(cur);
                node.left = cur;
                if(cur.right != null) {
                    q.add(cur.right);
                    node.right = cur.right;
                    cur = cur.right;
                }
                cur = cur.right;
            }
        }

        bst.setRoot(heap.head);
        bst.printLevelOrder();
    }

    private static class MinHeap {
        TNode head;

        public void add(TNode root) {
            root.right = null;
            root.left = null;
            if(head != null){
                root.right = head;
                head.left = root;
            }
            head = root;
        }
    }

    private static void heapify(ArrayList<TNode> heap, int i) {
        int l = 2*i+1;
        int r = 2*i + 2;

        if(l < heap.size()){
            heap.get(i).left = heap.get(l);
        } else {
            heap.get(i).left = null;
        }

        if(r < heap.size()){
            heap.get(i).right = heap.get(r);
        } else {
            heap.get(i).right = null;
        }
    }

    private static void printList(TNode head) {
        while (head != null) {
            System.out.print(head.i+" ");
            head = head.right;
        }

        System.out.println();
    }
    private static void doInOrder(TNode root, MinHeap heap) {
        if(root == null) return;
        TNode right = root.right;
        TNode left = root.left;
        doInOrder(right, heap);
        heap.add(root);
        doInOrder(left, heap);
    }
}
