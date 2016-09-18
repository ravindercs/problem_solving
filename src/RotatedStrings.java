/**
 * Created by ravinderk on 7/5/2016.
 */
public class RotatedStrings {
    public static void main(String[] args) {
        System.out.println(areRotatedUsingSubString("GEEK", "KGEE"));
        System.out.println(areRotatedUsingSubString("GEEK", "KEGE"));
    }

    private static boolean areRotatedUsingSubString(String s1, String s2) {
        if(s1 == null && s2 != null) return false;
        if(s1 != null && s2 == null) return false;
        if(s1 == null && s2 == null) return true;
        if(s1.length() != s2.length()) return true; // this will also verify length
        String s3 = s1 + s1;
        return s3.contains(s2);
    }

}