class Solution {
    public int climbStairs(int n) {
        
        return totalWays( n, new int[n+1]);
    }
    
    public int totalWays(int n , int[] memo){
        
        memo[0] = 1;
        memo[1] = 1;
        
        for(int i = 2 ; i <= n ; i++)
        {
            int onestep = memo[i-1];
            int twostep = memo[i-2];
        
            int ans = onestep + twostep;
            memo [i] = ans;
        }
        
        return memo[n];
    }
}