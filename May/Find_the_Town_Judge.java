/*
In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:
1.The town judge trusts nobody.
2.Everybody (except for the town judge) trusts the town judge.
3.There is exactly one person that satisfies properties 1 and 2.

You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

Example 1:
Input: N = 3, trust = [[1,2],[2,3]]
Output: -1

Example 2:
Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
*/
class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if (trust.length  < N-1)
            return -1;
        
        int[] trustlevel = new int[N+1];
        
        int judge = 1;
        for(int[] edge: trust) {
            trustlevel[edge[0]] = -1;
            if (trustlevel[edge[1]] != -1){
                trustlevel[edge[1]]++;
                if (trustlevel[edge[1]] == N-1) {
                    judge = edge[1];
                }
            }
        }
        return trustlevel[judge] == N-1 ? judge : -1;
    }
}
