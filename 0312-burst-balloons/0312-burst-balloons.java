class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int newNums[] = new int[n + 2];
        newNums[0] = 1;
        newNums[n+1] = 1;
        for(int i = 0; i < n; i++){
            newNums[i + 1] = nums[i];
        }
        
        int dp[][] = new int[n+1][n+1];
        
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        
        return maxProfit(1, n, newNums, dp);
        
    }
    
    private int maxProfit(int i, int j, int nums[], int dp[][]){
        if(i > j){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int max = Integer.MIN_VALUE;
        
        for(int ind = i; ind <= j; ind++){
            int cost = nums[i-1]*nums[ind]*nums[j+1] + maxProfit(i, ind - 1, nums, dp) + maxProfit(ind + 1, j, nums, dp);
            max = Math.max(max, cost);
        }
        
        return dp[i][j] = max;
        
    }
    
}