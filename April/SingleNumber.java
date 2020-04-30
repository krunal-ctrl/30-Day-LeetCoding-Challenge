class Solution {
    public int singleNumber(int[] arr) {
        int a=0;
        for(int i:arr)
            a^=i;
        return a;
    }
}
