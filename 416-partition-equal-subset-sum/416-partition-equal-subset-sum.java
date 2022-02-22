class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        
        if(sum % 2 != 0){
            return false;
        }
        
        sum = sum / 2;
        
        boolean[][] dp = new boolean[n + 1][sum + 1];
        
        for(int j = 0; j < sum + 1; j++){
            dp[n][j] = false;
        }
        
        for(int i = n; i >=0 ; i--){
            dp[i][0] = true;
        }
        
        for(int i = n - 1; i >= 0; i--){
            for(int j = 1;j < sum + 1; j++){
                
                if(j >= arr[i]){
                    dp[i][j] = dp[i + 1][j - arr[i]] || dp[i + 1][j]; 
                }
                else{
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][sum];
        
    }
    
}