/**
 * https://leetcode.com/problems/move-zeroes/
 */


public class MoveZeroes{
    /**
     * Use two pointers, one to iterate through array and another to track non-zero index
     * Time Complexity: O(n) because we iterate through whole array.
     * Space Complexity: O(1) constant space is used
     */
    public void moveZeroes(int[] nums){
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                // Assign non-zero number to slow pointer
                nums[index] = nums[i];
                index++;    // Increment slow pointer
            }
        }
        // Fill rest of array with zeroes
        for (int i = index; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}