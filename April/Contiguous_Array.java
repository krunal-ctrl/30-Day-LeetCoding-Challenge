Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
*/
class Solution {
    public int findMaxLength(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int max=0;
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            count+=(nums[i]==1)?1:-1;
            
            if(count==0){
                max=i+1;
            }
            if(map.containsKey(count)){
                max=Math.max(max,i-map.get(count));
            }
            else{
                map.put(count,i);
            }
        }
        return max;
    }
}
