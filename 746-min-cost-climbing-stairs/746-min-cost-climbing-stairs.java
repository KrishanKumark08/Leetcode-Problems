class Solution {
    // Muskaan Leetcode
public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        int memo[] = new int[n+1];
        
        memo[0] = cost[0];
        memo[1] = Math.min(memo[0] , 0) + cost[1];
        
        for(int i = 2 ; i<=n ; i++){
            
            memo[i] =  Math.min(memo[i-1] , memo[i-2]);
            if( i < n)
                memo[i] += cost[i];
        }
        return memo[n];
    }

}