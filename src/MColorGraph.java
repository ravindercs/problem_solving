import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ravinderk on 8/2/2016.
 */
public class MColorGraph {
    public static void main(String[] args) {
        mColorGraph(new int[][] {{0, 1, 1, 1},
                {1, 0, 1, 0},
                {1, 1, 0, 1},
                {1, 0, 1, 0},
        }, 3);
    }

    //Use BFS for coloring graph
    private static void mColorGraph(int[][] g, int m) {
        //Success - all vertices are colored such that no two adjacent vertices have same color
        //Next Sol - increase the color count
        for (int c = 1; c <= m; c++) {
            //BFS(g, c);
        }
        BFS(g);
        //Recur
        //Backtrack
    }

    private static void BFS(int[][] g) {
        boolean[] v = new boolean[g.length];
        Deque<Integer> q = new LinkedList<Integer>();
        q.push(0);
        v[0] = true;

        while (!q.isEmpty()) {
            int x = q.removeFirst();
            System.out.println(x+" ");
            for (int i = 0 ; i < g[0].length; i++) {
                if(g[x][i] == 1 && v[i] == false) {
                    v[i] = true;
                    q.addLast(i);
                }
            }
        }
    }
}
