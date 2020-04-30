/*
Say you have an array prices for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Input: [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
             Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
             
*/

class Solution {
    public int maxProfit(int[] prices) {
        
        //using peak valley approach [7,1,5,3,6,4]
        
        if(prices.length == 0) {
            return 0;
        }
        
        int maxProfit = 0;
        int peak = prices[0];
        int valley = prices[0];
        
        //find the valley->peak pairs in the array
        for(int i=0; i< prices.length-1; i++) {
            //find the next valley
            if(i < prices.length -1 && prices[i] <= prices[i+1]) {
                valley = prices[i];

                //find the consecutive peak
                peak = prices[i+1];
                maxProfit = maxProfit + (peak-valley);
               // System.out.println(valley + " " + peak + " " + i + " " + maxProfit);
            }
            
        }
        
        return maxProfit;
        
        
    }
}
