/**
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in 
 * non-decreasing order.
 * 
 * Given a row-sorted binary matrix binaryMatrix, return letfmost column index w/ at least a 1 in it.
 * If such index doesn't exist, return -1.
 * 
 * Given BinaryMatrix interface:
 *  BinaryMatrix.get(x, y) retusns element of matrix at index (x, y)
 *  BinaryMatrix.dimensions() returns list of 2 elements [m, n]
 */
public class LeftmostColumnWithOne {
    // Binary Search Approach
    // Time: O(mlogn) where m is number of rows and n is number of columns
    // Space: O(1)
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix){
        int m = binaryMatrix.dimensions.get(0);
        int n = binaryMatrix.dimensions.get(1);
        int left = 0;
        int right = n - 1;
        int leftmost = -1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (existOneInColumn(binaryMatrix, m, mid)){
                leftmost = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return leftmost;
    }
    public boolean existOneInColumn(BinaryMatrix binaryMatrix, int m, int c){
        for (int i = 0; r < m; r++){
            if (binaryMatrix.get(r, c) == 1){
                return true;
            }
        }
        return false;
    }

    // Linear Time Solution
    // Time: O(m + n) where m is number of rows, n is number of columns
    // Space: O(1)
    public int linear(BinaryMatrix binaryMatrix){
        int m = binaryMatrix.get(0);
        int n = binaryMatrix.get(1);
        int leftmost = -1;
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0){
            if (binaryMatrix.get(x, y) == 0){
                x++;
            } else {
                leftmost = y;
                y++;
            }
        }
        return leftmost;
    }
}