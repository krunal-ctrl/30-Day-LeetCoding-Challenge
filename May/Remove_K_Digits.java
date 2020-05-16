/*
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.

Example 1:
Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.

Example 2:
Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

Example 3:
Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
*/
class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (n == k)
            return "0";
        char[] chars = num.toCharArray();
        int top = -1;
        int i = 0;
        chars[++top] = chars[i++];
        for (int j = 0; j < k; j++) {
            while (true) {
                if (i == n) { // nothing to compare to anymore
                    top--;
                    break;
                }
                if (top >= 0 && chars[top] > chars[i]) {
                    top--;
                    break;
                }
                chars[++top] = chars[i++];
            }
        }
        //remove k digits
        while (top + 1 < n - k) {
            chars[++top] = chars[i++];
        }
        //removing the leading zero
        i = 0;
        while (i < top+1 && chars[i] == '0') {
            i++;
        }
        return i > top ? "0" : new String(chars, i, top + 1 - i);
    }
}
