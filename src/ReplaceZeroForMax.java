import java.util.Scanner;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class ReplaceZeroForMax {
    public static void main(String[] args) {
        System.out.println(getIndex("1100101110111"));
        System.out.println(getIndex("11110"));
        System.out.println(getIndex("111101111"));
    }

    //{1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1}
    private static int getIndex(String s) {
        int len = s.length();
        int maxZeroCount = 1;
        int zeroCount = 0;
        int lastZeroIndex = -1;
        int maxLen = 0;
        int start = 0;
        int subEnd = -1;
        int curLen = 0 ;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') {
                zeroCount++;
                if (zeroCount == maxZeroCount) {
                    lastZeroIndex = i;
                    curLen++;
                } else if (zeroCount > maxZeroCount) {
                    lastZeroIndex++;
                    start = lastZeroIndex;
                    curLen = i - start - 1;
                    zeroCount--;
                }
            } else {
                curLen++;
            }

            if (curLen > maxLen) {
                maxLen = curLen;
                subEnd = i;
            }
        }
        int zeroIndex = -1;
        for (int i = subEnd-curLen + 1 ; i <= subEnd ; i ++) {
            if(s.charAt(i) == '0') {
                zeroIndex = i;
                break;
            }
        }
        return zeroIndex;
    }
}
