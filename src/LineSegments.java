package com.ood.di;

/**
 * Created by ravinderk on 6/3/2017.
 */
public class LineSegments {
    static class Point { int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    //Find orientation p1,p2,p3
    private static int orientation(Point p1, Point p2, Point p3) {
        //slop of p1p2  and p2p3
        return (p2.y - p1.y)*(p3.x-p2.x) - (p3.y-p2.y)*(p2.x-p1.x);
    }

    public static void main(String[] args) {
        Point p1 = new Point(0,0);
        Point p2 = new Point(4,4);
        Point p3 = new Point(1,2);
        int slop = orientation(p1,p2,p3);
        String slopStr = slop == 0 ? "Collinear" : ((slop > 0) ? "Clockwise" : "Anti-Clockwise");
        System.out.print("Slop of" + p1 + p2 + p3 + " is "+slopStr);
    }
}
