package local.exercises.dynamic;

import java.util.*;

public class RunningSteps {

    public static int countCases(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countCases(n, memo);
    }

    public static int countCases(int n, int[] memo) {
        if(n < 0) {
            return 0;
        } else if(n == 0) {
            return 1;
        } else if(memo[n] > -1) { // cache hit
            return memo[n];
        } else { // cache miss
            memo[n] = countCases(n - 1, memo) + countCases(n - 2, memo) + countCases(n - 3, memo);
            return memo[n]; 
        }
    }

    public static void main(String[] args) {
        System.out.println(countCases(4));
    }
}