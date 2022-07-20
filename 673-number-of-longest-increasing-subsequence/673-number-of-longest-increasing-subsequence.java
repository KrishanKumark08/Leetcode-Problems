class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        for(int i = 0;i < n; i++){
            dp[i] = 1;
        }
        
        int[] count = new int[n];
        Arrays.fill(count, 1);
        
        int answer = 1;
        
        for(int i = 1;i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(1 + dp[j] > dp[i]){
                        dp[i] = 1 + dp[j];
                        count[i] = count[j];
                    }
                    else if(1 + dp[j] == dp[i]){
                        count[i] += count[j];
                    }
                }
                answer = Math.max(answer, dp[i]);
            } 
        }
        
        int totalCount = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == answer){
                totalCount += count[i];
            }
        }
        
        return totalCount;
    }
}