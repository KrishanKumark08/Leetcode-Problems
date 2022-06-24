class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> combinations = new HashSet<>();
        
        generateTotalWays(candidates, 0, target, combinations, new ArrayList<Integer>());
        
        return new ArrayList<List<Integer>>(combinations);
    }
public void generateTotalWays(int[] candidates, int currentIndex, int target, HashSet<List<Integer>> combinations, List<Integer> currentAns){
        
        if(target == 0){
            List<Integer> ans = new ArrayList<>(currentAns);
            Collections.sort(ans);
            combinations.add(ans);
            return;
        }       
        if(currentIndex >= candidates.length){
            return;
        }
        
        int currentVal = candidates[currentIndex];
        
        if(currentVal <= target){
            currentAns.add(currentVal);
            generateTotalWays(candidates, currentIndex + 1, target - currentVal, combinations, currentAns);
            currentAns.remove(currentAns.size() - 1);
            
        }
    
        while(currentIndex + 1 < candidates.length && candidates[currentIndex]==candidates[currentIndex + 1])
            currentIndex++; 
        generateTotalWays(candidates, currentIndex + 1, target, combinations, currentAns);
    }
    
}