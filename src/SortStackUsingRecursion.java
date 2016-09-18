import java.util.Stack;

/**
 * Created by ravinderk on 7/28/2016.
 */
public class SortStackUsingRecursion {
    public static void main(String[] args) {
        sortStack(new int[]{2,1,4,5,3});
        sortStack(new int[]{4,2,1,4,5,3});
    }

    //{2,1,4,5,3}
    private static void sortStack(int[] a) {
        if(a == null || a.length == 0) return;
        Stack<Integer> s = new Stack<Integer>();
        for (Integer i : a) {
            s.push(i);
        }
        sortStackRec(s);

        while (!s.empty()) {
            System.out.print(s.pop()+" ");
        }
        System.out.println();
    }

    private static void sortStackRec(Stack<Integer> s) {
        if(s.empty()) return;
        int top = s.pop();
        sortStackRec(s);
        sortedPush(s, top);
    }

    private static void sortedPush(Stack<Integer> s, int i) {
        if(s.empty() || i > s.peek()) {
            s.push(i);
            return;
        }

        int top = s.pop();
        sortedPush(s,i);
        s.push(top);
    }
}
