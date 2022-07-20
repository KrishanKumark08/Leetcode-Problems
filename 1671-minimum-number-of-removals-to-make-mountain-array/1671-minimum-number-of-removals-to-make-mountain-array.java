class Solution {
    public int minimumMountainRemovals(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        
        for(int i = 0;i < n; i++){
            dp[i] = 1;
        }
        
        //int answer1 = 1;
        for(int i = 1;i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
           // answer1 = Math.max(answer1, dp[i]);
        }
        
        int[] dp2 = new int[n];
        Arrays.fill(dp2, 1);
        
        //int answer2 = 1;
        
        for(int i = n - 1; i >= 0; i--){
            for(int j = n - 1; j > i; j--){
                if(nums[j] < nums[i] && 1 + dp2[j] > dp2[i]){
                    dp2[i] = 1 + dp2[j];
                }
            }
            //answer2 = Math.max(answer2, dp2[i]);
        }
        
        int answer = 1;
        
        for(int i = 0; i < n; i++){
            if(dp[i] > 1 && dp2[i] > 1)
                answer = Math.max(answer, dp[i] + dp2[i] - 1);
        }
        
        return n - answer;
        
    }
}