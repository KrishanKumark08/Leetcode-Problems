class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        min[0] = nums[0];
        
        int[] max = new int[n];
        max[0] = nums[0];
        
        int ans = nums[0];
        
        for(int i = 1; i < n; i++){
            max[i] = Math.max(nums[i], Math.max(max[i - 1]*nums[i], min[i - 1]*nums[i]));
            min[i] = Math.min(nums[i], Math.min(max[i - 1]*nums[i], min[i - 1]*nums[i]));
            
            ans = Math.max(ans, max[i]);
            
        }
        return ans;
    }
}