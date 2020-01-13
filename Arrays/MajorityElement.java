/**
 * https://leetcode.com/problems/majority-element/
 */


public class MajorityElement {
    /**
    * Boyer-Moore Majority Vote Algorithm
    * ASSUMED MAJORITY ELEMENT EXISTS
    * Time Complexity: O(n)
    * Space Complexity: O(1)
    */
    public int majority(int[] nums){
        int majority = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++){
            if (count == 0){
                majority = nums[i];
                count = 1;
            } else if (majority == nums[i]){
                count++;
            } else {
                count--;
            }
        }

        return majority;
    }
}