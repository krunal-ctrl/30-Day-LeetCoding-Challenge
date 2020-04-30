/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 */
class Solution {
    public boolean canJump(int[] nums) {
        /*
        int maxIndex=0;
        for(int i=0;maxIndex < nums.length -1;i++){
            if(nums[i]==0 && maxIndex <=i) 
                return false;
            maxIndex = Math.max(maxIndex,i+nums[i]);
        }
        return true;
        */
        int i= nums.length -2;
        while (i >= 0){
            if(nums[i] == 0){
                int zeroDist =0;
                while (nums[i] <=zeroDist){
                    zeroDist++;
                    i--;
                    if(i < 0) return false;
                }
            }
            i--;
        }
        return true;    
    }
}
