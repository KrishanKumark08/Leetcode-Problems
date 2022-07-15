class Solution {
    public int rob(int[] nums) {
        int n = nums.length ;
        if(nums.length == 1)return nums[0];
        if(nums.length == 2)return Math.max(nums[0] , nums[1]);
        
        int memo[] = new int[n + 1];
        
        memo[n] = 0;
        memo[n-1] = nums[n-1];
        
        
        for(int i = n-2 ; i >= 1 ; i-- )
        {
            int consider = nums[i] + memo[i+2];
            int notconsider = memo[i+1];
            
            memo[i] = Math.max(consider , notconsider);
        }
        memo[n] = 0;
        memo[n-1] = 0;
        for(int i = n-2 ; i >= 2 ; i-- )
        {
            int consider = nums[i] + memo[i+2];
            int notconsider = memo[i+1];
            
            memo[i] = Math.max(consider , notconsider);
        }
        memo[0] = memo[2] + nums[0];
        return Math.max(memo[0],memo[1]);
    }
}