class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = countcoins(coins ,amount );
        
        if(ans >= 1000000)
            return -1;
        
        return ans;
    }
    
    public int countcoins(int[] coins , int target){
        
        int n = coins.length;
        int dp[][] = new int[n+1][target+1];
        
        for(int i[] : dp)
            Arrays.fill( i , 1000000);
        
       for(int i = 0 ;  i < target+1 ; i++){
            
            dp[n][i] = 1000000;
        }
        for(int i = 0 ;  i < n+1 ; i++){
            
            dp[i][0] = 0;
        }
        
        for(int current = n-1 ; current >= 0 ;  current--)
        {
            for(int t = 1 ; t <= target ; t++)
            {
                int consider = 1000000;
                if(t >= coins[current])
                consider = 1 + dp[current][t - coins[current]];

                int notconsider =  dp[current + 1][t];
                dp[current][t] = Math.min(consider , notconsider);
            }
        }
        // for(int current = 0 ; current <= n ;  current++)
        // {
        //     for(int t = 0 ; t <= target ; t++)
        //     {
        //         System.out.print(dp[current][t]+" ");
        //     }
        //     System.out.println();
        // }
        
       
        return dp[0][target];
    }
}