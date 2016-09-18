import java.util.Arrays;

/**
 * Created by ravinderk on 7/30/2016.
 */
public class ArrLeastGreater {
    public static void main(String[] args) {
        test(new int[]{10, 20, 30, 50, 10, 70, 30});
        test(new int[]{1});
        test(new int[]{1,2});
        test(new int[]{2,1});
        test(new int[]{3,2,1});
        test(new int[]{4,5,8,7,3,2,1});
    }

    private static void test(int[] a) {
        if(a == null || a.length == 0) return;

        int[] t = new int[a.length];
        System.out.println(Arrays.toString(a));

        System.out.println("IC : "+countIC(a));
        System.out.println("IC : "+mergeSort(a, t, 0, a.length-1));

        System.out.println(Arrays.toString(a));
    }

    private static int countIC(int[] a) {
        int ic = 0;
        TNode root = new TNode(a[0]);
        for (int i = 1 ; i < a.length; i++) {
            ic += add(root, new TNode(a[i]));
        }
        return ic;
    }

    private static int add(TNode root, TNode node) {
        int ic = 0;
        if(root.i <= node.i) {
            if(root.right == null) {
                root.right = node;
            } else {
                ic = add(root.right, node);
            }
        } else {
            if(root.left == null) {
                root.left = node;
                ic = 1 + BinaryTree.getCount(root.right);
            } else {
                ic = 1 + add(root.left, node) + BinaryTree.getCount(root.right);
            }
        }
        return ic;
    }

    private static int mergeSort(int[] a, int[] t, int i, int j) {
        if(i < j) {

            int m = i + (j - i) / 2;

            int lic = mergeSort(a, t, i, m);

            int ric = mergeSort(a, t, m + 1, j);

            return lic + ric + merge(a, t, i, m + 1, j);
        }
        return 0;
    }

    private static int merge(int[] a, int[] t, int s, int m, int e) {

        int i = s, j = m, k = s, ic = 0;
        while (i <= m - 1 && j <= e) {
            if(a[i] <= a[j]) {
                t[k++] = a[i++];
            } else {
                ic += m-i;
                t[k++] = a[j++];
            }
        }

        while (i <= m-1) {
            t[k++] = a[i++];
        }

        while (j <= e) {
            t[k++] = a[j++];
        }

        while (s <= e) {
            a[s] = t[s++];
        }

        return ic;
    }
}
