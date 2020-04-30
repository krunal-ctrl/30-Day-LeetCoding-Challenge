/*
Write an algorithm to determine if a number n is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, 
replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), 
or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
*/
class Solution {
    public boolean isHappy(int n) {
    int sum,count;
    while(true){
        if (n == 1 || n == 7 ) return true;
        if ((n >=2 && n <=6)||(n >=8 && n <=9)) return false;
        sum=0;
        count=0;
        while(n>0){
            int tmp = n%10;
            sum+= tmp*tmp;
            n = n/10;
            count++;
        }
        n=sum;
    }
    }
}
