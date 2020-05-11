/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.
Note: Do not use any built-in library function such as sqrt.
*/
class Solution {
    public boolean isPerfectSquare(int num) {
        int digits = 0;
        int temp = num;
        
        while (temp != 0) {
            temp /= 10;
            digits++;
        }
        digits = (digits / 2) + 1;
        float guess = 1;
        for (; digits >= 0; digits--) {
            guess *= 10;
        }
        int prev = 0;
        while (prev != (int)guess) {
            prev = (int)guess;
            guess = 0.5f * (guess + num / guess);
        }
        if (prev * prev == num) return true;
        if ((prev + 1) * (prev + 1) == num) return true;
        return false;
    }
}
