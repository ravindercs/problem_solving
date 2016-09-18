/**
 * Created by ravinderk on 7/5/2016.
 */
public class ScreenShortestPath {
    public static void main(String[] args) {
        printShortestPath("GEEK");
        System.out.println();
        printShortestPath("ZOOM");
    }
//
//    A B C D E
//    F G H I J
//    K L M N O
//    P Q R S T
//    U V W X Y
//    Z
    private static void printShortestPath(String str) {
        int len = str.length();
        int curRow = 0;
        int curCol = 0;
        for (int i = 0 ; i < len; i++) {
            int nextCol = (str.charAt(i) - 'A')%5;
            int nextRow = (str.charAt(i) - 'A')/5;
            while (curRow > nextRow) {
                System.out.println("Move Up");
                curRow--;
            }

            while (curRow < nextRow) {
                System.out.println("Move Down");
                curRow++;
            }

            while (curCol > nextCol) {
                System.out.println("Move Left");
                curCol--;
            }

            while (curCol < nextCol) {
                System.out.println("Move Right");
                curCol++;
            }

            System.out.println("Press OK");
        }
    }


}