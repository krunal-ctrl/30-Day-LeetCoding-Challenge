/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, 
write a function that will return true if the ransom note can be constructed from the magazines ; 
otherwise, it will return false.

Note:
You may assume that both strings contain only lowercase letters.
canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) return false;
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray())
            ++cnt[c-97];
        for (char c : ransomNote.toCharArray())
            if (--cnt[c-97] < 0) return false;
        return true;
    }
}
