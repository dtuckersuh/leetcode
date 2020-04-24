/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * 
 * Ex:
 * Input: [1, 1, 1], k = 2
 * Output: 2 ([1, 1], [1, 1])
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k){
        // [1, 1, 1, 1], k = 3
        // ([1, 1, 1], [1, 1, 1]) = 2

        // [2, 2, 1, 1, 3], k = 4
        // ([2, 2], [2, 1, 1], [1, 3])

        // [4, -3, -2, 3, 4, -2], k = 2
        // ([4, -3, -2, 3], [-3, -2, 3, 4], [4, -2]), = 3
        
        // Numbers in array can be negative
        
        if (nums == null || nums.length == 0){
            return 0;
        }

        int result = 0;
        // <index where sum started, sum>
        // Initialize for every index 
        // Every iteration, add to previous sums

        // Brute Force Approach
        // Go through every possible continuous subarray and increment counter for those whose sum equals k

        for (int i = 0; i < nums.length; i++){      // What work is being repeated here?
            int j = nums.length - 1;
            while (j > i){                          // Computing sum of elements we have already seen
                int sum = 0;
                for (int m = i; m < j; m++){
                    sum += nums[m];
                }
                result += sum == k ? 1 : 0;
                j--;
            }    
        }


        // Single Traversal
        // Initialize Map<sum, frequency>
        // Initialize sum variable
        // Initialize counter variable
        // For every iteration
        // add element to sum variable
        // if element == k, increment counter
        // if sum - k is in map, increment counter
        // If sum is in map, increment sum frequency
        // We store sum frequency because there can be multiple partitions containing sum - k, add frequency to counter
        
        // How to optimize
        // Use data structure to store subarray
        // Store sum frequencies <sum, frequency>
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            // sum(i, j) = sum(0, j) - sum(0, i)
            // sum(i, j) represents sum of all elements from index to j - 1
            sum += nums[i];
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        // Return number of continuous subarrays whose sum = k
        return result;
    }
}