class Solution {
    public int climbStairs(int n) {
        int memo[] = new int[n+2];
        memo[n+1] = 0;
        memo[n] = 1;
        
        for(int i = n-1; i>= 0; i--){
            memo[i] = memo[i + 1] + memo[i + 2];
        }
        
        return memo[0];
        
        //return totalWays(0, n, new int[n]);
    }
    
    private int totalWays(int currentStair, int n, int dp[]){
        if(currentStair >= n){
            if(currentStair == n){
                return 1;
            }
            return 0;
        }
        
        if(dp[currentStair] != 0){
            return dp[currentStair];
        }
        
        int oneStep = totalWays(currentStair + 1, n, dp);
        int twoSteps = totalWays(currentStair + 2, n, dp);
        
        dp[currentStair] = oneStep + twoSteps;
        
        return oneStep + twoSteps;
        
    }
    
}