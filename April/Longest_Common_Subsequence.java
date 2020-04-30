/*

Solution
Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
If there is no common subsequence, return 0.

Example 1:
Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.

Example 2:
Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.

Example 3:
Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
*/
class Solution{
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0){
            return 0;
        }
        
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[2][n + 1];
        
        int flag = 0;
        for(int i = m; i >= 0; i--){
            for(int j = n; j >= 0; j--){
                if(i == m || j == n){
                    dp[flag][j] = 0;
                }
                else if(text1.charAt(i) == text2.charAt(j)){
                    dp[flag][j] = dp[flag ^ 1][j + 1] + 1;
                }
                else{
                    dp[flag][j] = Math.max(dp[flag ^ 1][j], dp[flag][j + 1]);
                }
            }
            flag ^= 1;
        }
        
        return dp[flag ^ 1][0];
    }
}
