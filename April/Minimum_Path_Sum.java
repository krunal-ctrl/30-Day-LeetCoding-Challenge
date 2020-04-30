/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum
*/
class Solution {
public int minPathSum(int[][] grid) {
   
       
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
   
        
        int n = grid.length-1;
        int m = grid[0].length-1;
        int[][] temp = new int[n+1][m+1];
        temp[n][m]=grid[n][m];
        return dfs(0,0,grid,temp);
		
		
    }
    
    public int dfs(int row, int col, int[][] grid, int[][] temp) {
        
        if (row > grid.length-1 || col > grid[0].length-1 ) return Integer.MAX_VALUE; 
		
        if (row == grid.length-1 && col == grid[0].length-1 ) return grid[row][col]; 
		
        if (temp[row][col] == 0) 
         
        {  temp[row][col]=grid[row][col]+Math.min(dfs(row+1,col,grid,temp),dfs(row,col+1,grid,temp));}
        return temp[row][col];
    }
}
