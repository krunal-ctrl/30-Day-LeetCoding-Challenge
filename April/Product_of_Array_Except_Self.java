/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans =new int[n];
        ans[0]=1;
        for(int i=1;i<n;i++)
            ans[i]=ans[i-1]*nums[i-1];
        n=1;
        for(int i=nums.length-1;i>=0;i--){
            ans[i]=n*ans[i];
            n*=nums[i];
        }
        return ans;
    }
}
