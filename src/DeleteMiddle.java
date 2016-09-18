import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class DeleteMiddle {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
        System.out.println(list);
        deleteMiddle(list);
        System.out.println(list);
    }

    private static void deleteMiddle(List<Integer> list) {
        if (list == null || list.isEmpty()) return;
        Iterator<Integer> slow = list.iterator();
        Iterator<Integer> fast = list.iterator();
        while (fast.hasNext()) {
            slow.next();
            fast.next();
            if(fast.hasNext()) {
                fast.next();
            }
        }

        if(list.size()%2 == 0 && slow.hasNext()) slow.next();
        slow.remove();
    }
}