class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max[] = new int[n];
        
        max[0] = nums[0];
        int answer = max[0];
        
        int min[] = new int[n];
        min[0] = nums[0];
        
        for(int i = 1; i < n; i++){
            int maxNum = Math.max(nums[i], Math.max(max[i - 1]* nums[i], min[i - 1]*nums[i]));
            int minNum = Math.min(nums[i], Math.min(max[i - 1]* nums[i], min[i - 1]*nums[i]));
    
                max[i] = maxNum;
                min[i] = minNum;
            
            answer = Math.max(answer, max[i]);
        }
        
        return answer;
        
    }
}