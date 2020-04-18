/**
 * Given a string containing only three types of characters: '(', '0' and '*', write a function to check whether this string is
 * valid. We define the validity of a string by these rules:
 *  1. Any left parenthesis must have corresponding right parenthesis
 *  2. Any right parenthesis must have corresponding left parenthesis
 *  3. Left parenthesis must go before corresponding right parenthesis
 *  4. '*' could be treated as single right parenthesis or single left parenthesis or empty string
 *  5. Empty string also valid
 * 
 * Example 1: "()" - true
 * Example 2: "(*)" - true
 * Example 3: "(*))" - true
 */
public class ValidParenthesisString {
    /**
     * Brute Force Approach:
     *  For each asterisk, try both possibilities
     *  Time Complexity: O(N * 3^N) where N is length of string. For each asterisk we try 3 different values.
     *                      Thus, we could be checking validity of up to 3^N strings. Each check of validity is O(N)
     * Space Complexity: O(N)
     */

     /**
      * Two Pointer Approach:
            - Keep two counters, each for separate kind of parenthesis. 
            - When we encounter '(', increment first counter. Decrement first counter when we encounter ')'
            - Opposite to second counter
            - In both cases, increment counters if we encounter '*'
            - If final result is >= 0 for any of counters, we know there are at least same number of open and closed parentheses
            - Else we have encountered more closing parentheses than opening ones
      */
      public boolean checkValidString(String s) {
          int openCounter = 0;
          int closeCounter = 0;
          int length = s.length() - 1;
          for (int i = 0; i <= length; i++){
              // Open Case
              char c = s.charAt(i);
              if (c == '*' || c == '('){
                  openCounter++;
              } else {
                  openCounter--;
              }

              // Close Case
              char end = s.charAt(s.length() - i);
              if (end == '*' || end == ')'){
                  closeCounter++;
              } else {
                  closeCounter--;
              }

              // Check if string is still valid 
              if (openCounter < 0 || closeCounter < 0){
                  return false;
              }
          }
          return true;
      }
}