class PerformStringShifts {
    /**
     * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
     *  - Direction can be 0 (for left shift) or 1 (for right shift). 
        
        - Amount is the amount by which string s is to be shifted.
        
        - A left shift by 1 means remove the first character of s and append it to the end.
        
        - Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
        
        - Return the final string after all operations.
        
        Constraints:
        1 <= s.length <= 100
        s only contains lowercase English letters
        1 <= shift.length <= 100
        shift[i].length == 2
        0 <= shift[i][0] <= 1
        0 <= shift[i][1] <= 100
    */
    public String stringShift(String s, int[][] shift){
        // Algorithm:
        // If direction = 1, sum += n
        // Else sum -= n
        // Shift string (n % s.length()) amount in +ve or -ve direction
        int sum = 0;
        for (int i = 0; i < shift.length; i++){
            int shamt = shift[i][1];
            sum += (shift[i][0] == 0) ? shamt * -1 : shamt;
        }
        sum %= s.length();
        if (sum < 0) {  // Shift left
            String sub = s.substring(0, sum * -1);
            return s.substring(sum * -1) + sub;
        }
        String sub = s.substring(s.length() - sum);
        return sub + s.substring(0, s.length() - sum);
    }
}