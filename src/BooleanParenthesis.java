package com.ood.di;

import java.util.Scanner;

/**
 * Created by ravinderk on 7/14/2017.
 */
public class BooleanParenthesis {
    //{|,&,^}
    //{T,T,F,F}
    //T(i) = o[i] = '|' => if(b[i] == true) 2*T(i-1)
    //                  => if(b[i] == false) T(i-1)
    //     = o[i] = '&' => if(b[i] == true) T(i-1)
    //     = o[i] = '^' => if(b[i] == false) T(i-1)
    //                  => if(b[i] == true)


    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        int t= s.nextInt();
        while( t-- > 0) {
            int n = s.nextInt();
            String exp = s.next();
            System.out.println(countTrueWays(exp,n));
        }
    }

    private static long countTrueWays(String exp, int len) {
        int n = (len+1)/2;
        char[] symb = new char[n];
        char[] op = new char[n-1];

        for (int i = 0, j = 0, k = 0; i < len ; i++) {
            char c = exp.charAt(i);

            if(c == 'T' || c == 'F') {
                symb[j++] = c;
            } else {
                op[k++] = c;
            }
        }

        long[][] T = new long[n][n];
        long[][] F = new long[n][n];

        for (int i = 0 ; i < n ; i++) {
            T[i][i] = symb[i] == 'T' ? 1 : 0;
            F[i][i] = symb[i] == 'F' ? 1 : 0;
        }

        for(int gap = 1 ; gap < n ; gap++) {
            for (int i = 0, j = gap; j < n ; i++,j++) {
                T[i][j] = F[i][j] = 0;
                for (int g = 0; g < gap; g++) {
                    int k = i + g;
                    long tik = T[i][k] + F[i][k];
                    long tkj = T[k+1][j] + F[k+1][j];

                    if(op[k] == '&') {
                        T[i][j] += T[i][k]*T[k+1][j] ;
                        F[i][j] += (tik*tkj - T[i][k]*T[k+1][j]);
                    } else if(op[k] == '|') {
                        F[i][j] += F[i][k]*F[k+1][j] ;
                        T[i][j] += (tik*tkj - F[i][k]*F[k+1][j]);
                    } else if(op[k] == '^') {
                        T[i][j] += F[i][k]*T[k+1][j] + T[i][k]*F[k+1][j];
                        F[i][j] += F[i][k]*F[k+1][j] + T[i][k]*T[k+1][j];
                    }
                    k = i + g;
                }
            }
        }

        return T[0][n-1]%1003;
    }

}
