class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0 ; 
        int maxi = nums[0];
        
        for(int i : nums){
            
            sum += i;
            sum = Math.max(sum , i);
            maxi = Math.max(maxi , sum);
        }
        
        return maxi;
    }
}