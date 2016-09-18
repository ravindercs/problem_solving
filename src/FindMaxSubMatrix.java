import java.util.Stack;

/**
 * Created by ravinderk on 7/18/2016.
 */
public class FindMaxSubMatrix {

    public static void main(String[] args) {
        findMaxSubMatrix(new int[][] {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        });
    }

    private static void findMaxSubMatrix(int[][] a) {
        int max_area = 0;
        int[] rowSum = new int[a[0].length];

        System.arraycopy(a[0],0,rowSum,0,a[0].length);

        max_area = maxRectangle(rowSum);

        for (int i = 1; i < a.length; i++) {
            for(int j = 0 ; j < a[0].length; j++) {
                if(a[i][j] == 1) {
                    rowSum[j] += 1;
                } else {
                    rowSum[j] = 0;
                }
            }
            max_area = Math.max(maxRectangle(rowSum), max_area);
        }

        System.out.println(max_area);
    }

    private static void printMat(int[][] a) {
        for (int[] r: a) {
            for (int e: r) {
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }

    private static int maxRectangle(int[] hist){
        int max_area = 0;
        int tp;  // To store top of stack
        int area_with_top; // To store area with top bar as the smallest bar
        Stack<Integer> s = new Stack<Integer>();
        int i = 0;
        while (i < hist.length)
        {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.empty() || hist[s.peek()] <= hist[i])
                s.push(i++);

                // If this bar is lower than top of stack, then calculate area of rectangle
                // with stack top as the smallest (or minimum height) bar. 'i' is
                // 'right index' for the top and element before top in stack is 'left index'
            else
            {
                tp = s.peek();  // store the top index
                s.pop();  // pop the top

                // Calculate the area with hist[tp] stack as smallest bar
                area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

                // update max area, if needed
                if (max_area < area_with_top) {
                    max_area = area_with_top;
                }
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (!s.empty())
        {
            tp = s.peek();
            s.pop();
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top) {
                max_area = area_with_top;
            }
        }

        return max_area;
    }
}
