/*
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input: 
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
*/
class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[2][n];
        int max = -1;
        int flag = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 || j == 0){
                    dp[flag][j] = matrix[i][j] - '0';
                }
                else{
                    dp[flag][j] = matrix[i][j] == '1' 
                        ? Math.min(dp[flag ^ 1][j], Math.min(dp[flag][j - 1], dp[flag ^ 1][j - 1])) + 1 : 0;
                }
                max = Math.max(max, dp[flag][j]);
            }
            flag ^= 1;
        }
        
        return max * max;
    }
}
