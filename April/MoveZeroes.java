/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
*/

class Solution {
    public void moveZeroes(int[] a) {
        int j=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=0)
                a[j++]=a[i];
        }
        while(j<a.length)
            a[j++]=0;
    }
}
