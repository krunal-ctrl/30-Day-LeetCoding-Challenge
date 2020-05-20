/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

The order of output does not matter.

Example 1:

Input:
s: "cbaebabacd" p: "abc"

Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
*/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int pl = p.length();
        int sl = s.length();
        
        if (sl < pl)
            return Collections.emptyList();
        
        short[] pMap = new short[26];
        for (int i = 0; i < pl; i++) {
            pMap[p.charAt(i) - 'a']++;
        }
        
        short[] sMap = new short[26];
        for (int i = 0; i < pl; i++) {
            sMap[s.charAt(i) - 'a']++;
        }
        
        boolean isAnagram = true;
        for (int i = 0; i < pMap.length; i++) {
            if (pMap[i] != sMap[i]) {
                isAnagram = false;
                break;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (isAnagram) {
            ans.add(0);
        }
        
        for (int i = pl; i < sl; i++) {
            sMap[s.charAt(i) - 'a']++;
            sMap[s.charAt(i-pl) - 'a']--;
            isAnagram = true;
            for (int j = 0; j < pMap.length; j++) {
                if (pMap[j] != sMap[j]) {
                    isAnagram = false;
                    break;
                }
            }
            if (isAnagram) 
                ans.add(i - pl + 1);
        }
        return ans;
    }
}
