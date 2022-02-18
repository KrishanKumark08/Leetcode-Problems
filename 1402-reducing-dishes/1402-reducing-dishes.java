class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        return maxTimeCoefficient(satisfaction, 1, 0, new HashMap<>());
    }
    
    private int maxTimeCoefficient(int[] satisfaction, int currentTime, int currentDish, HashMap<String, Integer> memo){
        if(currentDish >= satisfaction.length){
            return 0;
        }
        
        String currentKey = currentTime + "_" + currentDish;
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        
        int consider = satisfaction[currentDish] * currentTime + maxTimeCoefficient(satisfaction, currentTime + 1, currentDish + 1, memo);
        
        int notConsider = maxTimeCoefficient(satisfaction, currentTime, currentDish + 1, memo);
        
        memo.put(currentKey, Math.max(consider, notConsider));
        return memo.get(currentKey);
        
    }
    
}