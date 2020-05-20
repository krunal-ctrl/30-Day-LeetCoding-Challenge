/*
Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.

Example 1:

Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input:s1= "ab" s2 = "eidboaoo"
Output: False
*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int pl = s1.length();
        int sl = s2.length();
        if (pl > sl)
            return false;
        
        short[] count = new short[26];
        
        /*for (int i = 0; i < pl; i++) {
            count[s1.charAt(i) - 'a']--;
            count[s2.charAt(i) - 'a']++;
        }*/

        for(int i = 0; i < sl - pl; i++){
            int k = 0;
            makeZero(count);
            for (int j = i; j < i + pl; j++) {
                count[s2.charAt(j) - 'a']++;
                count[s1.charAt(k++) - 'a']--;
            }
            if(allZero(count)){
                return true;
            }
            
        }
        
        /*if(allZero(count)){
            return true;
        }*/
        return false;
    }
    
    private boolean allZero(short[] count) {
        for (int i = 0; i < 26; i++) {
             if(count[i] != 0) 
                 return false;
        }
        return true;
    }
    
    private void makeZero(short[] count) {
        for (int i = 0; i < 26; i++) {
            count[i] = 0;
        }
    }
}
