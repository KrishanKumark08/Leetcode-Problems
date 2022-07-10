class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
            return nums[0];
        return Math.max(maxProfit(nums,0, nums.length - 1, new HashMap<Integer,Integer>()), maxProfit(nums,1, nums.length , new HashMap<Integer,Integer>()) );
    }
    public int maxProfit(int[] nums, int currentIndex, int last, HashMap<Integer,Integer> memo){
        
        if(currentIndex >= last)
            return 0;
        
        int currentKey = currentIndex;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int rob = nums[currentIndex] + maxProfit(nums, currentIndex + 2, last, memo);
        
        int notRob = maxProfit(nums, currentIndex + 1, last, memo);
        
        memo.put(currentKey, Math.max(rob, notRob));
        return memo.get(currentKey);
    }
}
