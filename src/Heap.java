import java.util.List;

/**
 * Created by ravinderk on 7/6/2016.
 */
public interface Heap {
    void heapify(int i);
    int pop();
    int top();
    int getSize();
    void print();
    void buildHeap();
}
