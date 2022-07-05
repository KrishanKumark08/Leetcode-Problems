class Solution {
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return Math.min(minCost(cost, 0, memo), memo.get(1));
    }
    
    private int minCost(int[] cost, int currentIndex, HashMap<Integer, Integer> memo){
        if(currentIndex >= cost.length){
            return 0;
        }
        
        if(memo.containsKey(currentIndex)){
            return memo.get(currentIndex);
        }
        
        memo.put(currentIndex, cost[currentIndex] + Math.min(minCost(cost, currentIndex + 1, memo), minCost(cost, currentIndex + 2, memo)));
        return memo.get(currentIndex);
        
    }
    
}