class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        
        dp[0]=nums[0];
        
        for(int i=1 ; i<nums.length;i++)
        {
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
        }
        
        int sum=-10000;
        for(int i=0 ; i<nums.length;i++)
            sum=Math.max(sum,dp[i]);
        
        return sum;
    }
}