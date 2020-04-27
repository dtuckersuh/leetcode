/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive
 * [5, 7]
 *   0101 
 *   0110 
 * & 0111
 * -------
 *   0100 = 4
 * 
 * [0, 1]
 *   0000
 * & 0001
 * -------
 *   0000 = 0
 */
public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n){
        // 1. Last bit of (odd number & even number) is 0
        // 2. When m != n, there is at least an odd number and an even number. So last bit position result is 0.
        // 3. Move m and n right a position
        if (m == 0) {
            return 0;
        }
        int moveFactor = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }
}