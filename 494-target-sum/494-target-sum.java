class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum = 0;
        target = Math.abs(target); // There can be negative targets
                                    // Number of possibilities for negative targets will be same as
                                    // Number of Possibilites for positive target
        for(int i : nums)
        {
            sum += i;
        }
        
        if((target + sum)% 2 != 0) // Whether it is possible to do this partition or not
            return 0;
       
        if(target == 0 && sum == 0) // If array is containing all the 0 elements and target is also 0
                                    // So ans will be all the subsets.
            return (int)Math.pow(2 ,nums.length);
        
        target = (target+ sum)/2;
        
        Arrays.sort(nums); // To avoid issues caused due to 0s in the array
                            // This way array will come at beginning and that problem will be solved
        return subsetsum(nums , target) ;
    }
   public int subsetsum( int[] nums ,int target){
        
        if(target == 0)
            return 0;
        
        int n = nums.length;
        int dp[][] = new int[n+1][target+1];
        
        for(int i = 0 ; i < target+1 ; i++){
            dp[n][i] = 0;
        }
        
        for(int i = 0 ; i < n+1 ; i++){
            dp[i][0] = 1;
        }
        
        for(int current = n-1 ; current >= 0 ; current--){
            
            for(int t = 1 ; t <= target ; t++){
    dp[current][t] = dp[current + 1][t] +  ((t - nums[current] >= 0) ? dp[current+1][t - nums[current]] : 0 );
                
            } // Similar to number of subsets with given difference
        }
       
       for(int current =0 ; current <= n ; current++){
            for(int t = 0 ; t <= target ; t++){
                System.out.print(dp[current][t] + "  ");
            }
            System.out.println();
       }
       
        return dp[0][target];
    }
}