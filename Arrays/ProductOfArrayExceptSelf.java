
/**
 * Given an array nums of n integers where n > 1, return an array output such that output[i] is equal to the product
 * of all the elements of nums except nums[i].
 * 
 * Ex:
 *  Input: [1, 2, 3, 4]
 *  Output: [24, 12, 8, 6]
 * 
 * Constraint:
 *  Solve without division and in O(n)
 * 
 * Follow up:
 *  Solve with constant space complexity. Output array does not count as extra space.
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums){
        // Approach 1: Left and Right product lists
        // Get product of all numbers to left and to the right of the index
        // Multiplying the two individual products give us desired result

        // Algorithm:
        // 1. Initialize two empty arrays, left and right where for given index i,
        //      left[i] would contain product of all numbers to the left of i and
        //      right[i] would contain product of all the numbers to the right of i.
        // 2. Need two different loops to fill in values for the two arrays.
        //      For left array, left[0] will be 1 since no elements to left of first element
        //      For rest of the elements, use L[i] = L[i - 1] * nums[i - 1]
        // 3. For right array, same thing but reverse. Start w/ initial value of 1
        //      in right[length - 1] and keep updating right in reverse
        //      right[i] = right[i + 1] * nums[i + 1]
        // 4. Iterate over input array and for reach element at index i, find product except self as left[i] * right[i];

        // Left initialization
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++){
            left[i] = left[i - 1] * nums[i - 1];
        }

        // Right initialization
        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--){
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] product = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            product[i] = left[i] * right[i];
        }
        return product;
    }

    /**
     * Constant space implementation 
     * Same idea except instead of creating array for products right of index, store right product in variable.
     * */ 
    public int[] constantSpace(int[] nums){
        int[] product = new int[nums.length];
        product[0] = 1;
        for (int i = 1; i < nums.length; i++){
            product[i - 1] = product[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            product[i] = product[i] * right;
            right *= nums[i];
        }
        return product;
    }
}