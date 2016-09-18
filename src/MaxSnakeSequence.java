import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class MaxSnakeSequence {
    private static int maxLen = 0;
    private static int maxI = -1;
    private static int maxJ = -1;
    public static void main(String[] args) {
        int[][] a = new int[][] {
                {1, 2, 5, 2},
                {5, 7, 8, 5},
                {6, 7, 8, 6},
                {7, 1, 1, 7}};
//        {1, 0, 1, 0},
//        {1, 2, 3, 4},
//        {2, 0, 0, 5},
//        {0, 0, 0, 6}};
        int[][] T = findMaxSnake(a);
        System.out.println("Max Snake "+maxLen);
        Stack<String> snake = new Stack<String>();
        for (int  i = 0 ; i < T.length; i++) {
            for (int j = 0 ; j < T[0].length; j++) {
                System.out.print(T[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("MaxI "+maxI+" MaxJ " +maxJ);
        int i = maxI ,j = maxJ;
        while (T[i][j] != 0){
            if (i > 0 && T[i][j] - T[i-1][j] == 1) {
                snake.push(a[i - 1][j] + "->" + a[i][j]);
                i--;
            } else if (j > 0 && T[i][j] - T[i][j - 1] == 1){
                snake.push(a[i][j - 1] + "->" + a[i][j]);
                j--;
            }
        }

        while (!snake.isEmpty()) {
            System.out.println(snake.pop());
        }
    }

    private static int[][] findMaxSnake(int[][] a) {
        int[][] T = new int[a.length][a[0].length];
        for (int i = 0 ; i < a.length ; i++) {
            for(int j = 0 ; j < a[0].length; j++) {
                if(i == 0 && j ==0) {
                    T[i][j] = 0;
                } else {
                    if(j > 0 && Math.abs(a[i][j] - a[i][j-1]) == 1) {
                        T[i][j] = Math.max(T[i][j], T[i][j-1] +1);
                        if(maxLen < T[i][j]) {
                            maxLen = T[i][j];
                            maxI = i;
                            maxJ = j;
                        }
                    }
                    if(i > 0 && Math.abs(a[i][j] - a[i-1][j]) == 1) {
                        T[i][j] = Math.max(T[i][j], T[i-1][j] +1);
                        if(maxLen < T[i][j]) {
                            maxLen = T[i][j];
                            maxI = i;
                            maxJ = j;
                        }
                    }
                }
            }
        }

        return T;
    }
}