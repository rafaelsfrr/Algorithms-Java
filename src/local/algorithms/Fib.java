package local.algorithms;

import java.util.*;

public class Fib {

    public static int fib(int n) {
        return fib(n, new int[n + 1]);
    }

    public static int fib(int n, int[] memo) {
        if(n == 0 || n == 1) return n;

        // cache miss
        if(memo[n] == 0) {
            return fib(n - 1, memo) + fib(n - 2, memo);
        }
        
        // cache hit
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(Integer.parseInt(args[0])));
    }
}

/* 
    In this first code we have a top-down approach. We can also use a bottom-up:

    public static int fib(int n) {
        if(n == 0 || n == 1) return n;

        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for(int i = 2; i < n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n - 1] + memo[n - 2];
    }

    However, we have O(n) in space. But, we just need two values to calculate the next, so we can refactor the code to be O(1) in space.    

    public static int fib(int n) {
        if(n == 0 || n == 1) return n;

        int a = 0;
        int b = 1;

        for(int i = 2; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return a + b;
    }
*/
