/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand
 * Given a target value to search, if found in array return its index, otherwise return -1
 * 
 * Assume no duplicate exists in array
 * Runtime must be O(logn)
 */
public class SearchInRotatedArray {
    public int search(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return -1;
        }
        // Find pivot w/ Binary Search
        int start = findPivot(nums);
        int left = 0;
        int right = nums.length - 1;
        if (target >= nums[start] && target <= nums[right]){                
            left = start;
        } else {
            right = start;
        }
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (target > nums[mid]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int findPivot(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]){   // If middle element is greater, narrow search space down to [mid + 1, right]
                left = mid + 1;
            } else {                        // Else middle is <= right, narrow search space down to [left, mid]
                right = mid; 
            }
        }
        return mid;
    }
}