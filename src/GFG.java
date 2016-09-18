import java.util.Scanner;

class GFG {
    private static double distance(
            int x1, int y1,
            int x2, int y2)
    {
        return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
    }

    private static boolean isSquare(
            int x1, int y1,
            int x2, int y2,
            int x3, int y3,
            int x4, int y4
    ){
        double d12 = distance(x1,y1,x2,y2);
        System.out.println("d12: "+d12);
        double d13 = distance(x1,y1,x3,y3);
        System.out.println("d13: "+d13);
        double d14 = distance(x1,y1,x4,y4);
        System.out.println("d14: "+d14);
        double d23 = distance(x2,y2,x3,y3);
        System.out.println("d23: "+d23);
        double d24 = distance(x2,y2,x4,y4);
        System.out.println("d24: "+d24);
        double d34 = distance(x3,y3,x4,y4);
        System.out.println("d34: "+d34);

        return (d12 == d13 && d23 == d14)
                || (d12 == d14 && d24 == d13)
                || (d13 == d14 && d34 == d12);
    }

    public static void main (String[] args) {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        // One by one run for all input test cases
        while (t > 0)
        {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int x3 = sc.nextInt();
            int y3 = sc.nextInt();
            int x4 = sc.nextInt();
            int y4 = sc.nextInt();

            System.out.println(isSquare(x1,y1,x2,y2,x3,y3,x4,y4) ? 1 : 0);
            t--;
        }
    }
}