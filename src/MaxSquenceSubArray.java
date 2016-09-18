import java.util.HashSet;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class MaxSquenceSubArray {
    public static void main(String[] args) {
        System.out.println(getMaxLength(new int[] {10, 12, 11}));
        System.out.println(getMaxLength(new int[] {14, 12, 11, 20}));
        System.out.println(getMaxLength(new int[] {1, 56, 58, 57, 90, 92, 94, 93, 91, 45}));
    }

    //{1, 56, 58, 57, 90, 92, 94, 93, 91, 45}
    private static int getMaxLength(int[] arr) {
        int maxLen = 1;
        int start = 0;
        int curMax = arr[0];
        int curMin = arr[0];
        int curLen = 0;
        for (int i = 1 ; i < arr.length -1 ; i++ ) {
            curMin = arr[i];
            curMax = arr[i];
            HashSet<Integer> set = new HashSet<Integer>();
            set.add(arr[i]);
            for (int j = i+1; j < arr.length; j++) {
                if(set.contains(arr[j])) break;
                curMin = Math.min(curMin, arr[j]);
                curMax = Math.max(curMax, arr[j]);
                if(curMax - curMin == j - i) {
                    maxLen = Math.max(maxLen, curMax - curMin + 1);
                }
            }
        }
        return maxLen;
    }
}