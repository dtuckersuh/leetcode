/**
 * 525. Contigous Array
 * 
 * Given binary array, find max length of contiguous subarray with equal number of 0s and 1s 
 */
class ContiguousArray {
    /**
     * Brute force:
     * 
     * Find all possible subarrays and store max subarray w/ equal amounts of 0s and 1s
     * Time Complexity: O(n^n)
     * Space Complexity: O(1);
     * 
     * HashMap Approach:
     * 
     * Initialize Map to store <sum, index>
     * Initialize sum variable, if nums[i] == 0, decrement sum, else increment sum
     * If sum is 0, we know number of 0s and 1s so far in array are equal
     * Else use da map
     * If map has seen the sum before, the subarray from current index to map index has equal 0s and 1s
     * Else put sum in map with corresponding index 
     */
    public int findMaxLength(int[] nums){
        if (nums.length == 1){
            return 0;
        }
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int longestContArray = 0;
        for (int i = 0; i < nums.length; i++){
            sum += (nums[i] == 0 ? -1 : 1);
            if (sum == 0) {
                longestContArray = i + 1;
            } else {
                if (map.containsKey(sum)){
                    longestContArray = Math.max(longestContArray, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return longestContArray;
    }
}