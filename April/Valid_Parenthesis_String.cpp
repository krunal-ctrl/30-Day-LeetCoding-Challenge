/*
iven a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.

Example 1:
Input: "()"
Output: True

Example 2:
Input: "(*)"
Output: True

Example 3:
Input: "(*))"
Output: True
*/
class Solution {
    public boolean checkValidString(String s) {
        int len=s.length(),left=0;
        Stack <Character> stack =new Stack();
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if (c=='(')
                stack.push(c);
            else if (c==')'){
                if(!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else if(left > 0)
                    left--;
                else
                    return false;
            }
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                    left++;
                }
                left++;
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }
}
//sb.lastIndexOf(String str)  sb.deleteCharAt(index);
