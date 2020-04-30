//Given a non-empty array of integers, every element appears twice except for one. Find that single one.
class Solution {
    public int singleNumber(int[] arr) {
        int a=0;
        for(int i:arr)
            a^=i;
        return a;
    }
}
