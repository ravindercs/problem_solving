/**
 * Created by ravinderk on 7/20/2016.
 */
public class MirrorTreeFinder {
    public static void main(String[] args) {
        testSample();
        testNull();
        testOneTrue();
        testOneFalse();
        testTwoTrue();
        testTwoFalse();
    }

    private static boolean isMirror(TNode first, TNode second) {
        if(first == null && second == null) return true;
        if(first == null || second == null) return false;

        return first.i == second.i && isMirror(first.left, second.right)
                && isMirror(first.right, second.left);
    }

    private static void testSample() {
        TNode first = new TNode(1);
        first.left = new TNode(3);
        first.right = new TNode(2);
        first.right.left = new TNode(5);
        first.right.right = new TNode(4);

        TNode second = new TNode(1);
        second.left = new TNode(2);
        second.right = new TNode(3);
        second.left.left = new TNode(4);
        second.left.right = new TNode(5);

        System.out.println(isMirror(first, second));
    }

    private static void testOneTrue() {
        System.out.println(isMirror(new TNode(1), new TNode(1)));
    }

    private static void testOneFalse() {
        System.out.println(isMirror(new TNode(1), new TNode(2)));
    }

    private static void testNull() {
        System.out.println(isMirror(null, new TNode(2)));
    }

    private static void testTwoTrue() {
        TNode first = new TNode(1);
        first.left = new TNode(2);

        TNode second = new TNode(1);
        second.right = new TNode(2);

        System.out.println(isMirror(first, second));
    }

    private static void testTwoFalse() {
        TNode first = new TNode(1);
        first.left = new TNode(2);

        TNode second = new TNode(1);
        second.left = new TNode(2);

        System.out.println(isMirror(first, second));
    }
}
