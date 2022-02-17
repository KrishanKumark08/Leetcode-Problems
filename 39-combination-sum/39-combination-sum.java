class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> combinations = new ArrayList<>();
        
        generateTotalWays(candidates, 0, target, combinations, new ArrayList<Integer>());
        
        return combinations;
        
    }
    
    public void generateTotalWays(int[] candidates, int currentIndex, int target, List<List<Integer>> combinations, List<Integer> currentAns){
        
        if(target == 0){
            combinations.add(new ArrayList<>(currentAns));
            return;
        }       
        if(currentIndex >= candidates.length){
            return;
        }
        
        int currentVal = candidates[currentIndex];
        
        if(currentVal <= target){
            currentAns.add(currentVal);
            generateTotalWays(candidates, currentIndex, target - currentVal, combinations, currentAns);
            currentAns.remove(currentAns.size() - 1);
        }
        
        generateTotalWays(candidates, currentIndex + 1, target, combinations, currentAns);
        
        
    }
    
}