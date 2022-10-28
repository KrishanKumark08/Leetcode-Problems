class Solution {
    public int rob(int[] nums) {
        int n = nums.length ;
        if(n == 1){
            return nums[0];
        }
        
        int memo[] = new int[n + 1];
        
        memo[n] = 0;
        memo[n-1] = nums[n-1];
        
        for(int i = n-2 ; i >= 1 ; i-- )
        {
            int consider = nums[i] + memo[i+2];
            int notconsider = memo[i+1];
            memo[i] = Math.max(consider , notconsider);
        }
        
        int one = memo[1];
        
        memo[n] = 0;
        memo[n-1] = 0;
        for(int i = n-2 ; i >= 0 ; i-- )
        {
            int consider = nums[i] + memo[i+2];
            int notconsider = memo[i+1];
            memo[i] = Math.max(consider , notconsider);
        }
        
        //memo[0] = memo[2] + nums[0];
        
        return Math.max(memo[0],one);
    }
}