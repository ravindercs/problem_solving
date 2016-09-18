/**
 * Created by ravinderk on 7/6/2016.
 */
public class MaxHeap implements Heap {
    int[] a ;
    int size = 0;
    MaxHeap(int[] arr) {
        a = arr;
        size = a.length;
        buildHeap();
    }

    @Override
    public void buildHeap() {
        for (int i = (a.length-2)/2 ; i >= 0; --i) {
            heapify(i);
        }
    }

    @Override
    public void heapify(int i) {
        int max = i;
        int l = 2*i + 1;
        int r = 2*i + 2;
        if(l < size && a[i] < a[l]) {
            max = l;
        }

        if(r < size && a[max] < a[r]) {
            max = r;
        }

        if(max != i) {
            int t = a[max];
            a[max] = a[i];
            a[i] = t;
            heapify(max);
        }
    }

    @Override
    public int pop() {
        if(size < 0) return -1;
        int temp = a[0];
        a[0] = a[size];
        size--;
        heapify(0);
        return temp;
    }

    @Override
    public int top() {
        if(size < 0) return -1;
        return a[0];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void print() {
        for (int i = 0 ; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
