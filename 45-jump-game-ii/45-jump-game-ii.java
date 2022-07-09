class Solution {
    public int jump(int[] nums) {
        return minJump(nums, 0, new HashMap<Integer, Integer>());
    }
    
    private int minJump(int[] nums, int currentIndex, HashMap<Integer, Integer> memo){
        
        if(currentIndex >= nums.length - 1){
            return 0;
        }
        
        if(memo.containsKey(currentIndex)){
            return memo.get(currentIndex);
        }
        
        int ans = 10001;
        for(int i = 1; i <= nums[currentIndex]; i++){
            int tempAns = 1 + minJump(nums, currentIndex + i, memo);
            ans = Math.min(ans, tempAns);
        }
        
        memo.put(currentIndex, ans);
        return ans;
        
    }
    
}