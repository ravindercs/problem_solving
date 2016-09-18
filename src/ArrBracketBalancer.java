import java.util.Stack;

/**
 * Created by ravinderk on 7/28/2016.
 */
public class ArrBracketBalancer {
    private static int testNo = 1;
    public static void main(String[] args) {
        test1("}{"); //1
        test1("{{{");//2
        test1("{{{{");//3
        test1("{{{{}}");//4
        test1("}{{}}{{{");//5
        test1("{}{{}}}}}");//6
        test1("}{}{}}");//7
        test1("{{{}");//8
        test1("{{{}{{{{{}}{");//9
        test1("{");
        test1("}");
    }

    private static int getReversalCount(String a) {
        if(a == null || a.length() == 0) return 0;

        if(a.length() % 2 != 0) return -1;

        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < a.length(); i++) {
            if(s.empty()) {
                s.push(a.charAt(i));
            } else {
                if (s.peek() == '{' && '}' == a.charAt(i)) {
                    s.pop();
                } else {
                    s.push(a.charAt(i));
                }
            }
        }

        int rs = s.size();
        int n = 0;
        while (!s.empty()) {
            if(s.pop() == '{') {
                n++;
            }
        }

        return rs/2 + n%2;
    }

    private static void test1(String a) {
        System.out.println("-----Test "+(testNo++)+"--------");
        System.out.println(getReversalCount(a));
        System.out.println(getLengthOfLongestValidSubString(a));
    }

    private static int getLengthOfLongestValidSubString(String a) {
        if(a == null || a.length() == 0) return 0;
        int result = 0;
        Stack<Integer> s = new Stack<Integer>();
        s.push(-1);

        for(int i = 0 ; i < a.length(); i++) {
            if(a.charAt(i) == '{') {
                s.push(i);
            } else {
                s.pop();
                if(!s.empty()) {
                    result = Math.max(result, i - s.peek());
                } else {
                    s.push(i);
                }
            }
        }

        return result;
    }
}
