class Solution {
    public int coinChange(int[] coins, int amount) {
        int h=coinchange(coins,amount);
        if(h==100000)
            return -1;
        return h;
    }
    private int coinchange(int[] coins,int amount)
    {
        int[][] dp= new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;i++)
        {
            for(int j =0;j<amount+1;j++)
            {
                if(j == 0)
                    dp[i][j]=0;
                if(i == coins.length)
                    dp[i][j]=100000;
            }
        }
       for(int i=coins.length-1;i>=0;i--)
        {
            for(int j =1;j<amount+1;j++)
            {
                if(j-coins[i]>=0)
                      dp[i][j]=Math.min(1+dp[i][j-coins[i]] ,dp[i+1][j]) ;
                else
                    dp[i][j] = dp[i+1][j];
            }
        }
        return dp[0][amount];
    }
}