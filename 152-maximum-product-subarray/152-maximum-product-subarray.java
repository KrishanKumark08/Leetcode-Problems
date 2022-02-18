class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        int min = nums[0];
        int max = nums[0];
        
        int answer = nums[0];
        
        for(int i = 1; i < n; i++){
            int maxNum = Math.max(nums[i], Math.max(max* nums[i], min*nums[i]));
            int minNum = Math.min(nums[i], Math.min(max* nums[i], min*nums[i]));
    
                max = maxNum;
                min = minNum;
            
            answer = Math.max(answer, max);
        }
        
        return answer;
        
    }
}