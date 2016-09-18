import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class DecimalFromBinLL {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(0);
        list.add(0);
        System.out.println(getNumber(list));
    }

    private static long getNumber(List<Integer> list) {
        long n = 0;
        for (Integer i: list) {
            n = n*2 + i;
        }
        return n;
    }
}