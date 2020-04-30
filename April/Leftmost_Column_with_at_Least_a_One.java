/*
(This problem is an interactive problem.)

A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.

You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:

BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
BinaryMatrix.dimensions() returns a list of 2 elements [rows, cols], which means the matrix is rows * cols.
Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.

For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
*/
/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int x, int y) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions=binaryMatrix.dimensions();
        int rows = dimensions.get(0);
        int cols = dimensions.get(1);
        int leftmost=cols;
        
        for(int row=0;row<rows;row++){
            int left=0;
            int right=cols-1;
            if(leftmost < right)
                right = leftmost-1;
            
            int rightBit=binaryMatrix.get(row,right);
            if(rightBit == 0)
                continue;
            
            int col=cols;
            while(left <= right){
                int middle = left+(right-left)/2;
                int middleBit=binaryMatrix.get(row,middle);
                if(middleBit == 0){
                    left = middle+1;
                    continue;
                }
                if(middle == 0)
                    return 0;
                int prevBit = binaryMatrix.get(row,middle-1);
                if(prevBit==0){
                    col=middle;
                    break;
                }
                right = middle -1;
            }
            if(col<leftmost)
                leftmost=col;
        }
            
 
        return leftmost == cols ? -1:leftmost;
    }
}
