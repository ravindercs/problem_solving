/**
 * Created by ravinderk on 7/19/2016.
 */
public class MinToMaxHeap {
    public static void main(String[] args) {
        int[] a = new int[]{3,5,9,6,8,20,10,12,18,9};

        MaxHeap maxHeap = new MaxHeap(a);
//        for (int i = 0 ; i < a.length; i++) {
//            maxHeap.insert(a[i]);
//        }
        maxHeap.print();
    }
}
