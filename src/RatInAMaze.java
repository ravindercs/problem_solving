import java.util.Arrays;

/**
 * Created by ravinderk on 8/1/2016.
 */
public class RatInAMaze {
    public static void main(String[] args) {
        solveRatInAMaze(new int[][]{
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}});
    }

    private static void solveRatInAMaze(int[][] maze) {
        int[][] sol = new int[maze.length][maze[0].length];
        sol[0][0] = 1;
        if(solveRatInAMaze(maze, sol, 0, 0)) {
            for(int i = 0 ; i < sol.length; i++) {
                System.out.println(Arrays.toString(sol[i]));
            }
        } else {
            System.out.println("Not possible");
        }
    }

    private static int[] ni = new int[] {1,0} ;
    private static int[] nj = new int[] {0,1} ;
    private static boolean solveRatInAMaze(int[][] maze, int[][] sol, int i, int j) {
        if( i == maze.length - 1 && j == maze[0].length - 1) {
            return true;
        }

        for (int k = 0 ; k < ni.length ; k++) {
            int nexti = i + ni[k];
            int nextj = j + nj[k];
            if (isSafe(maze, nexti, nextj)) {
                sol[nexti][nextj] = 1;
                if(solveRatInAMaze(maze, sol, nexti, nextj)) {
                    return true;
                }
                sol[nexti][nextj] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] maze, int i, int j) {
        return i >= 0 && i < maze.length && j >= 0 && j < maze[0].length && maze[i][j] == 1;
    }
}
