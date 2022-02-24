class Solution {
    public int change(int amount, int[] coins) {
        
        int n = coins.length;
        int memo[][] = new int[n + 1][amount + 1];
        
        for(int j = 0; j < amount + 1; j++){
            memo[n][j] = 0;
        }
        
        for(int i = 0; i < n + 1; i++){
            memo[i][0] = 1;
        }
        
        
        for(int i = n - 1; i >= 0; i--){
            for(int j = 1; j < amount + 1; j++){
                if(j >= coins[i]){
                    memo[i][j] = memo[i][j - coins[i]] + memo[i+1][j];
                }
                else{
                    memo[i][j] = memo[i + 1][j];
                }
            }
        }
        
        return memo[0][amount];
        
    }
}