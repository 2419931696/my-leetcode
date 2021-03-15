package com.example.myleetcode.offer;

public class Solution10II {
    public int numWays(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        int p = 0;
        int q = 1;
        for(int i=0; i<n; i++) {
            int temp = (p+q)%1000000007;
            p = q;
            q = temp;
        }
        return q;
    }
}
