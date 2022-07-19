class Solution {
    public int lengthOfLIS(int[] nums) {
        return LIS(nums, 0, -1, new int[nums.length][nums.length + 1]);
    }
    
    private int LIS(int nums[], int currentIndex, int prev, int[][] dp){
        if(currentIndex >= nums.length){
            return 0;
        }
        
        if(dp[currentIndex][prev + 1] != 0){
            return dp[currentIndex][prev + 1];
        }        
        
        int len = LIS(nums, currentIndex + 1, prev, dp);
        
        if(prev == -1 || nums[currentIndex] > nums[prev]){
            len = Math.max(len, 1 + LIS(nums, currentIndex + 1, currentIndex, dp));
        }
        
        dp[currentIndex][prev + 1] = len;
        return len;
        
    }
    
}