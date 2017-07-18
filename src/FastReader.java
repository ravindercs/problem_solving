package com.ood.di;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ravinderk on 6/11/2017.
 */
public class FastReader {
    private BufferedReader br;
    private StringTokenizer st;
    public FastReader(InputStream is) {
        br = new BufferedReader(new InputStreamReader(is));
    }

    public int nextInt() {
        return Integer.parseInt(readIfNeeded());
    }

    private String readIfNeeded() {
        if(st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return st.nextToken();
    }
}
