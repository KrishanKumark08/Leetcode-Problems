class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCost(cost,0,new HashMap<Integer,Integer>()),minCost(cost,1,new HashMap<Integer,Integer>()));
    }
    public int minCost(int[] cost,int currentIndex,HashMap<Integer,Integer> memo)
    {
        if(currentIndex >= cost.length)
            return 0;
        
        int currentKey = currentIndex;
        
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int oneJump = cost[currentIndex] + minCost(cost,currentIndex + 1,memo);
        int twoJump = cost[currentIndex] + minCost(cost,currentIndex + 2,memo);
        
        memo.put(currentKey,Math.min(oneJump,twoJump));
        
        return Math.min(oneJump,twoJump);
    }
}