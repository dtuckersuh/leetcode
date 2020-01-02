
/**
 * https://leetcode.com/problems/house-robber
 * Steps to approach DP
 * 1. Find recursive relation
 * 2. Recursive (top-down)
 * 3. Recursive + memo (top-down)
 * 4. Iterative + memo (bottom-up)
 * 5. Iterative + N variables (bottom-up)
 */
public class HouseRobber {
    /**
     * Step 1. Figure out recursive relation
     * 2 options: 
     *  a) rob current house i: current house + prev houses
     *  b) don't rob current house: prev house + any loot before
     * rob(i) = Math.max(rob(i - 2) + currentHouse, rob(i-1))
     *
     * Step 2. Recursive(top-down)
     */
    public int robTopDownRecurse(int[] nums) {
        return robTopDownRecurse(nums, nums.length - 1);
    }
    // Processes same i multiple times, need improvement
    private int robTopDownRecurse(int[] nums, int i){
        if (i < 0){
            return 0;
        }
        return Math.max(robTopDownRecurse(nums, i - 2) + nums[i], 
        robTopDownRecurse(nums, i - 1));
    }

    /**
     * Step 3. Recursive + memo(top-down)
     * Time Complexity: O(n)
     * Space Complexity: O(n) because of recursion stack
     */
    int[] memo;
    public int robRecurseMemo(int[] nums){
        memo = new int[nums.length];
        return robRecurseMemo(nums, nums.length - 1);
    }
    private int robRecurseMemo(int[] nums, int i){
        if (i < 0){
            return 0;
        }
        if (memo[i] >= 0){
            return memo[i];
        }
        int result = Math.max(robRecurseMemo(nums, i - 2) + nums[i],
            robRecurseMemo(nums, i - 1));
        memo[i] = result;
        return result;
    }

    /**
     * Step 4. Iterative + memo (bottom-up)
     */
    public int robIterMemo(int[] nums){
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < memo.length; i++){
            memo[i] = Math.max(nums[i] + memo[i - 2], memo[i - 1]);
        }
        return memo[nums.length - 1];
    }

    /**
     * Step 5. Iterative + 2 variables (bottom-up)
     * Hold memo[i - 2] and memo[i - 1] in two variables
     */
    public int robIterVar(int[] nums){
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums){
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }
}