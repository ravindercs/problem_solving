package com.ood.di;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Created by ravinderk on 6/29/2017.
 */
public class FindVowel2ConsentSubString {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        findSubStrings("abcdeefghiajklifasljfdalkshfdoafeadshcljsacdalgfsacbmbvcmxbvalhdlkahsdfqpiueoiruaflksadfxncmxzbc" +
                "vjdalkfahslgasdkfjajsfsbashfdkajsdhfakjsahfdkjasdhfaieurlakshldjfasgfsafdsajfiwaeyfalksdhfsalkjdfnmvzxc" +
                "jklhiuerpiuewpohasdkjfhalsdfhsaodifuwpoiefhaskjdfhalkjdsfphiwefasdfakjsfdglashdfkppooidfnuwoiureousoiea" +
                "bvmzxcbvkajdhfksdhfljsadhfaksdfjhlsadgflkdsagfsfdjaoifyeiakvnlsabvljdhsaffabcdeefghiajklifasljfdalkshfdoafeadshcljsacdalgfsacbmbvcmxbvalhdlkahsdfqpiueoiruaflksadfxncmxzbc" +
                "vjdalkfahslgasdkfjajsfsbashfdkajsdhfakjsahfdkjasdhfaieurlakshldjfasgfsafdsajfiwaeyfalksdhfsalkjdfnmvzxc" +
                "jklhiuerpiuewpohasdkjfhalsdfhsaodifuwpoiefhaskjdfhalkjdsfphiwefasdfakjsfdglashdfkppooidfnuwoiureousoiea" +
                "bvmzxcbvkajdhfksdhfljsadhfaksdfjhlsadgflkdsagfsfdjaoifyeiakvnlsabvljdhsaffabcdeefghiajklifasljfdalkshfdoafeadshcljsacdalgfsacbmbvcmxbvalhdlkahsdfqpiueoiruaflksadfxncmxzbc" +
                "vjdalkfahslgasdkfjajsfsbashfdkajsdhfakjsahfdkjasdhfaieurlakshldjfasgfsafdsajfiwaeyfalksdhfsalkjdfnmvzxc" +
                "jklhiuerpiuewpohasdkjfhalsdfhsaodifuwpoiefhaskjdfhalkjdsfphiwefasdfakjsfdglashdfkppooidfnuwoiureousoiea" +
                "bvmzxcbvkajdhfksdhfljsadhfaksdfjhlsadgflkdsagfsfdjaoifyeiakvnlsabvljdhsaffabcdeefghiajklifasljfdalkshfdoafeadshcljsacdalgfsacbmbvcmxbvalhdlkahsdfqpiueoiruaflksadfxncmxzbc" +
                "vjdalkfahslgasdkfjajsfsbashfdkajsdhfakjsahfdkjasdhfaieurlakshldjfasgfsafdsajfiwaeyfalksdhfsalkjdfnmvzxc" +
                "jklhiuerpiuewpohasdkjfhalsdfhsaodifuwpoiefhaskjdfhalkjdsfphiwefasdfakjsfdglashdfkppooidfnuwoiureousoiea" +
                "bvmzxcbvkajdhfksdhfljsadhfaksdfjhlsadgflkdsagfsfdjaoifyeiakvnlsabvljdhsaffabcdeefghiajklifasljfdalkshfdoafeadshcljsacdalgfsacbmbvcmxbvalhdlkahsdfqpiueoiruaflksadfxncmxzbc" +
                "vjdalkfahslgasdkfjajsfsbashfdkajsdhfakjsahfdkjasdhfaieurlakshldjfasgfsafdsajfiwaeyfalksdhfsalkjdfnmvzxc" +
                "jklhiuerpiuewpohasdkjfhalsdfhsaodifuwpoiefhaskjdfhalkjdsfphiwefasdfakjsfdglashdfkppooidfnuwoiureousoiea" +
                "bvmzxcbvkajdhfksdhfljsadhfaksdfjhlsadgflkdsagfsfdjaoifyeiakvnlsabvljdhsaff");
        System.out.println(System.currentTimeMillis()-start);
    }

    private static void findSubStrings(String s) {
        LinkedList<String> res = new LinkedList<>();
        LinkedList<Integer> c = new LinkedList<>();
        for (int i = 0 ; i < s.length(); i++) {
            if(!isVowel(s.charAt(i))) {
                c.add(i);
            }
        }

        for (int i = 0 ; i < s.length(); i++) {
            if(c.size() == 0) break;
            if(c.getFirst() > i) {
                res.add(s.substring(i,c.getFirst()+1));
                res.add(s.substring(i,c.getLast() + 1));
            } else {
                c.removeFirst();
            }
        }

        Collections.sort(res);
        System.out.println(res.getFirst());
        System.out.println(res.getLast());
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
