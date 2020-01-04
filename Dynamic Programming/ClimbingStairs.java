/**
 * https://leetcode.com/problems/climbing-stairs/
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ClimbingStairs{
    /**
     * Brute Force: Take all possible step combinations every step
     * climbStairs(i, n) = (i + 1, n) + climbStairs(i + 2, n)
     * Time Complexity: O(n^2) because size of recursion tree is 2^n
     * Space Complexity: O(n) because depth of tree is n
     */
    public int climbStairsBrute(int n){
        return climbStairsBrute(0, n);
    }
    public int climbStairsBrute(int i, int n){
        if (i > n){
            return 0;
        }
        if (i == n){
            return 1;
        }
        return climbStairsBrute(i + 1, n) + climbStairsBrute(i + 2, n);
    }
    /**
     * Recursion with Memoization
     * Stores result of each step in memo and directly returns result from memo array
     * Prunes recursion tree and reduces size of tree up to n
     * Time Complexity: O(n) because size of recursion tree is n
     * Space Complexity: O(n) because depth of recursion tree is n
     */
    public int climbStairsRecurse(int n){
        int memo[] = new int[n + 1];
        return climbStairsRecurse(0, n, memo);
    }
    public int climbStairsRecurse(int i, int n, int[] memo){
        if (i > n){
            return 0;
        }
        if (i == n){
            return 1;
        }
        if (memo[i] > 0){
            return memo[i];
        }
        memo[i] = climbStairsRecurse(i + 1, n, memo) + climbStairsRecurse(i + 2, n, memo);
        return memo[i];
    }

    /**
     * Dynamic Programming
     * Optimal substructure property: optimal sol. constructed from optimal sol. of subproblem
     * Reach i-th step from one of two ways:
     *  1. Taking single step from (i - 1)-th step
     *  2. Taking step of 2 from (i - 2)-th step
     * Total number of ways to reach i-th = ways of reaching (i-1)-th + (i - 2)-th
     * dp[i] = dp[i - 1] + dp[i - 2]
     * Time Complexity: O(n) because single loop up to n
     * Space Complexity: O(n) because steps array of size n used
     */
    public int climbStairs(int n){
        // Base Cases
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        // Fib sequence
        int[] steps = new int[n + 1];
        steps[0] = 0;
        steps[1] = 1;
        steps[2] = 2;
        for (int i = 3; i <= n; i++){
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[n];
    }

    /**
     * Fib Number
     * Fib(n) = Fib(n - 1) + Fib(n - 2)
     * Time Complexity: O(n)
     * Space Complexity: O(1) constant space
     */
    public int climbStairsFib(int n){
        if (n == 1){
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++){
            int third = first + second;     // Fib(n - 2) + Fib(n - 1)
            first = second;                 // Fib(n - 2)
            second = third;                 // Fib(n - 1)
        }
        return second;
    }
}