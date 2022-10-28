class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n+2];
        
        memo[n+1] = 0;
        memo[n] = 0;
        
        for(int i = n - 1; i >= 0; i--){
            int rob = nums[i] + memo[i + 2];
            int notRob = memo[i + 1];
            
            memo[i] = Math.max(rob, notRob);
            
        }
        
        return memo[0];
    }
}