class Solution {
    public int climbStairs(int n) {
        return totalWays(0, n, new int[n]);
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