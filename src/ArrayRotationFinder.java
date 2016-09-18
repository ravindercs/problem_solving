public class ArrayRotationFinder {
    public static void main(String[] args) {
        int[] a = new int[]{50,55,63,74,90,104,10,20,25,30,35};
        System.out.println(findRotationCountUtil(a));
        a = new int[]{70,70,89,120,160,169,202,304,2,3};
        System.out.println(findRotationCountUtil(a));
        testfindRotationCountUtil();
        //System.out.println(findRotationCountUtil(new int[]{4,1,2,3}));
    }

    private static int findRotationCountUtil(int[] a) {
        if(a == null || a.length <= 1) return -1;
        return findRotationCount(a,0,a.length-1);
    }

    private static int findRotationCount(int[] a, int i, int j) {
        if( i >= j ) {
            return i;
        }

        int m = (i+j)/2;

        if(a[m] > a[j]) {
            i = m+1;
        } else {
            j = m;
        }

        return findRotationCount(a,i,j);
    }

    private static void testfindRotationCountUtil() {
        //Check for null
        assert findRotationCountUtil(null) == -1;
        assert findRotationCountUtil(new int[]{1}) == -1;
        assert findRotationCountUtil(new int[]{1,2}) == 0;
        assert findRotationCountUtil(new int[]{2,1}) == 1;
        assert findRotationCountUtil(new int[]{4,1,2,3}) == 1;
        assert findRotationCountUtil(new int[]{4,5,1,2,3}) == 2;
        assert findRotationCountUtil(new int[]{50,55,63,74,90,104,10,20,25,30,35}) == 6;
        //duplicates
        assert findRotationCountUtil(new int[]{1,1,2,3}) == 0;
        assert findRotationCountUtil(new int[]{3,1,1,2}) == 1;
        //assert findRotationCountUtil(new int[]{3,1,1,2}) == 2;
    }
}
