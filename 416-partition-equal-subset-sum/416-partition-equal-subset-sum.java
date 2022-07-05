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
        if(sum == 0){
            return true;
        }
        
        if(currentIndex >= nums.length || sum < 0){
            return false;
        }
        
        String currentKey = currentIndex + "_" + sum;
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        
        boolean consider = isPossible(nums, sum - nums[currentIndex], currentIndex + 1, memo);
        if(consider == true){
            return true;
        }
        boolean notConsider = isPossible(nums, sum, currentIndex + 1, memo);
        
        
        memo.put(currentKey, consider || notConsider);
        return memo.get(currentKey);
        
    }
    
}