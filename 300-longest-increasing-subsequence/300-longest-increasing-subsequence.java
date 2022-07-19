class Solution {
    public int lengthOfLIS(int[] nums) {
        return longestincsubs(nums);
    }
    public int longestincsubs(int[] nums)
    {
        int dp[][] = new int[nums.length+1][nums.length+1];
        for(int current = nums.length-1; current>=0 ; current--){
            
            for(int prev = current - 1; prev>=-1 ; prev--){
                
                int consider = 0;
                if(prev == -1 || nums[current] > nums[prev])
                    consider = 1 + dp[current+1][current+1];
                
                int notconsider =  dp[current+1][prev+1];
                dp[current][prev+1] = Math.max(consider , notconsider);
            }
        }
        
        return dp[0][0];
    }
}