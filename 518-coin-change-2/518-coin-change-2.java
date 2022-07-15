class Solution {
    public int change(int amount, int[] coins) {
        int ans = countcoins(coins ,amount);
        return ans;
    }
    
    public int countcoins(int[] coins ,int target){
        
        int n = coins.length;
        int dp[][] = new int[n+1][target+1];
        
        
        for(int i = 0 ; i<target+1 ; i++)
            dp[n][i] = 0;
        
        for(int i = 0 ; i<n+1 ; i++)
            dp[i][0] = 1;
        
        for(int current = n-1; current >= 0 ; current--){
            
            for(int t = 1 ; t<= target ; t++)
            {
                 int consider = 0;
                if(t >= coins[current])
                consider = dp[current][t - coins[current]];

                int notconsider =  dp[current + 1][t];
                dp[current][t] = consider + notconsider;
            }
        }
       
        
        return dp[0][target];
    }
}