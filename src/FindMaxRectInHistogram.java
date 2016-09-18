import java.util.Stack;

/**
 * Created by ravinderk on 7/18/2016.
 */
public class FindMaxRectInHistogram {
    public static void main(String[] args) {
        //int[] a = {6, 2, 5, 4, 5, 1, 6};
        int[] a = {2,3,3,2};
        //1,2
        naive(a);
        smallestBar(a);
        order_n_solution(a);
    }

    private static void order_n_solution(int[] hist){
        int max_area = 0; // Initalize max area
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
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (!s.empty())
        {
            tp = s.peek();
            s.pop();
            area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }

        System.out.println(max_area);
    }

    private static void smallestBar(int[] a) {
        int maxArea = a[0];
        for (int i = 0 ; i < a.length; i++) {
            int l = i; int r = i;
            while (l>=0 && a[i] <= a[l]) l--;
            while (r<a.length && a[i] <= a[r]) r++;
            int area = (r-l-1)*a[i];
            maxArea = Math.max(area, maxArea);
        }
        System.out.println(maxArea);
    }

    private static void naive(int[] a) {
        int maxArea = a[0];
        for (int i = 0 ; i < a.length; i++) {
            int min = a[i];
            for(int j  = i+1 ; j < a.length; j++) {
                if(a[j] < min ) {
                    min = a[j];
                }
                if((j-i+1)*min > maxArea) {
                    maxArea = (j-i+1)*min;
                }
            }
        }
        System.out.println(maxArea);
    }
}
