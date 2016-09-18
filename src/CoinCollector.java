import java.util.Stack;

/**
 * Created by ravinderk on 7/18/2016.
 */
public class CoinCollector {

    public static void main(String[] args) {
        char[][] maze = { {'E', 'C', 'C', 'C', 'C'},
                {'C', '#', 'C', '#', 'E'},
                {'#', 'C', 'C', '#', 'C'},
                {'C', 'E', 'E', 'C', 'E'},
                {'C', 'E', '#', 'C', 'E'}
        };

        printMat(maze);

        System.out.println(collectCoins(maze));
    }

    static class Point {
        int i,j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static int collectCoins(char[][] maze) {
        if(maze[0][0] == '#') return 0;

        Stack<Point> stack = new Stack<Point>();

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[0][0] = true;
        stack.push(new Point(0,0));

        int coins = 0;
        boolean face = true; // right
        while (!stack.empty()) {
            Point p = stack.pop();
            if(maze[p.i][p.j] == 'C') coins++;
            if(face) {//right
                if(isSafe(visited, p.i, p.j+1) && maze[p.i][p.j +1] != '#') {
                    stack.push(new Point(p.i,p.j+1));
                    visited[p.i][p.j+1] = true;
                }

                if(isSafe(visited, p.i+1, p.j) && maze[p.i+1][p.j] != '#') {
                    stack.push(new Point(p.i +1, p.j));
                    visited[p.i+1][p.j] = true;
                    face = false;//face left
                }
            } else {//left
                if(isSafe(visited, p.i, p.j-1) && maze[p.i][p.j - 1] != '#') {
                    stack.push(new Point(p.i,p.j-1));
                    visited[p.i][p.j-1] = true;
                }

                if(isSafe(visited, p.i+1, p.j) && maze[p.i+1][p.j] != '#') {
                    stack.push(new Point(p.i +1, p.j));
                    visited[p.i+1][p.j] = true;
                    face = true;//face right
                }
            }
        }

        return coins;
    }


    private static boolean isSafe(boolean[][] a, int i , int j) {
        return i >= 0 && i < a.length && j >= 0 && j < a[0].length && !a[i][j];
    }

    private static void printMat(char[][] a) {
        for (char[] r: a) {
            for (Character e: r) {
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }
}
