import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/**
 * https://leetcode.com/problems/single-number/
 */
public class SingleNumber{

    // Approach 1: List Operation
    // Time Complexity: O(n^2)
    // Space Complexity: O(n). List of size n to contain elements in nums
    public int listSolution(int[] nums){
        // Create list
        ArrayList<Integer> dup = new ArrayList<>();
        // Iterate over all elements
        for (int i = 0; i < nums.length; i++){
            // If some number in nums is new to array, append it
            if (!contains(nums, nums[i])){
                dup.add(nums[i]);
            } else {    // If some number already in array, remove
                dup.remove(nums[i]);
            }
        }
        return dup.get(0);
    }

    private boolean contains(int[] nums, int n){
        for (int i : nums){
            if (i == n){
                return true;
            }
        }
        return false;
    }

    // Approach 2: Hash Table
    // Time Complexity: O(n). For loop is O(n). Hash Table remove operation is O(1)
    // Space Complexity: O(n). Hash table is n size.
    public int hashSolution(int[] nums){
        // Iterate through all elements in nums
        HashTable<Integer, Integer> table = new HashTable<>(); 
        for (int i : nums){
            // Try if hashTable has key for pop
            if (table.containsKey(i)){
                table.remove(i);
            } else {
                table.put(i, 1);
            }
            // Return only element in table
            return (Integer) table.keySet().iterator().next();
        }
    }

    /**
     * Approach 3: Math
     * 2 * (a + b + c) - (a + a + b + b + c) = c
     * Time Complexity: O(n + n) = O(n) because sum(list(i, for i in nums)))
     * Space Complexity: O(n + n) = O(n) because set needs space for elements in nums
     */
    public int mathSolution(int[] nums){
        int sumA = 0;
        int sumB = 0;
        Set<Integer> mySet = new HashSet<>(Arrays.asList(nums));
        Iterator<E> iter = mySet.iterator();
        while (iter.hasNext()){
            sumA += iter.next();
        }
        for (int i : nums){
            sumB += i;
        }
        return 2 * sumA - sumB;
    }
    /**
     * Approach 4: Bit Manipulation
     * Take XOR of zero and some bit, returns that bit
     * Take XOR of same two bits, return 0
     * So XOR all bits together to find unique number
     * Time Complexity: O(n) because we only iterate once through nums
     * Space Complexity: O(1)
     */
    public int xorSolution(int[] nums){
        int n = 0;
        for (int i : nums){
            n ^= i;
        }
        return n;
    }
}
