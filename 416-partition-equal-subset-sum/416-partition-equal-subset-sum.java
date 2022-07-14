class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        
        if(sum % 2 != 0){
            return false;
        }
        
        return isPossible(nums, sum / 2, 0, new HashMap<String, Boolean>());
        
    }
    
    private boolean isPossible(int[] nums, int sum, int currentIndex, HashMap<String, Boolean> memo){
        int n = nums.length;
        
        if(sum == 0){
            return true;
        }
        
        boolean[][] dp = new boolean[n + 1][sum + 1];
        
        for(int j = 0; j < sum + 1; j++){
            dp[n][j] = false;
        }
        
        for(int i = 0; i <= n; i++){
            dp[i][0] = true;
        }
        
        for(int i = n -1; i >= 0; i--){
            for(int j = 1; j <= sum; j++){
                dp[i][j] = dp[i+1][j] || ((j - nums[i] >= 0) ? dp[i + 1][j - nums[i]] : false);
            }
        }
        
        return dp[0][sum];
        
//         if(sum == 0){
//             return true;
//         }
        
//         if(currentIndex >= nums.length || sum < 0){
//             return false;
//         }
        
//         String currentKey = currentIndex + "_" + sum;
//         if(memo.containsKey(currentKey)){
//             return memo.get(currentKey);
//         }
        
//         boolean consider = isPossible(nums, sum - nums[currentIndex], currentIndex + 1, memo);
//         if(consider == true){
//             return true;
//         }
//         boolean notConsider = isPossible(nums, sum, currentIndex + 1, memo);
        
        
//         memo.put(currentKey, consider || notConsider);
//         return memo.get(currentKey);
        
    }
    
}