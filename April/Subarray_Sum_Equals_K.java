/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
*/
class Solution {
    public int subarraySum(int[] arr, int k) {
        int n=arr.length;
        HashMap <Integer, Integer> prevSum = new HashMap<>();
        int res = 0;
        int currsum = 0;
        
        for (int i = 0; i < n; i++) {
            currsum += arr[i];
            if (currsum == k)   
                res++;
            if (prevSum.containsKey(currsum - k))   
                res += prevSum.get(currsum - k);
            Integer count = prevSum.get(currsum); 
            if (count == null) 
                prevSum.put(currsum, 1); 
            else
                prevSum.put(currsum, count+1);  
        }  
        return res;
    }
}
