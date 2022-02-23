class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        
        int n = arr.length;
        
        int sum = 0;
        for(int i:arr){
            sum += i;
        }
        
        if(sum < Math.abs(target) || (sum+target)%2!=0) return 0;
        
        sum = ( sum + target ) / 2;
    
        int[][] dp = new int[n + 1][sum + 1];
        
        for(int j = 0; j < sum + 1; j++){
            dp[n][j] = 0;
        }
        
        for(int i = n; i >=0 ; i--){
            dp[i][0] = 1;
        }
        
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0;j < sum + 1; j++){
                
                if(j >= arr[i]){
                    dp[i][j] = dp[i + 1][j - arr[i]] + dp[i + 1][j]; 
                }
                else{
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        
        return dp[0][sum];
        
    }
}