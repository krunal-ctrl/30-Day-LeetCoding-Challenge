/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
*/
class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] s=S.toCharArray();
        char[] t=T.toCharArray();
        
        StringBuffer sb=new StringBuffer();
        StringBuffer tb=new StringBuffer();
        
        for(int i=0;i<s.length;i++){
            if(s[i]=='#' && sb.length()!=0)
                sb.deleteCharAt(sb.length()-1);
            else if(s[i]!='#')
                sb.append(s[i]);
        }

        for(int i=0;i<t.length;i++){
            
            if(t[i]=='#' && tb.length()!=0)
                tb.deleteCharAt(tb.length()-1);
            else if(t[i]!='#')
                tb.append(t[i]);
        }
        return (sb.toString().equals(tb.toString()));
    }
}
