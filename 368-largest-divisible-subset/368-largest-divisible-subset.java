class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        int[] dp = new int[n];
        
        for(int i = 0;i < n; i++){
            dp[i] = 1;
        }
        
        int hash[] = new int[n];
        int lastIndex = 0;
        
        int answer = 1;
        
        for(int i = 1;i < n; i++){
            hash[i] = i;
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[i];
                    hash[i] = j;
                }
                
                if(dp[i] > answer){
                    answer = dp[i];
                    lastIndex = i;
                }
            } 
        }
        
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[lastIndex]);
        
        while(hash[lastIndex] != lastIndex){
            lastIndex = hash[lastIndex];
            ans.add(nums[lastIndex]);
        }
        
        return ans;
        
    }
}