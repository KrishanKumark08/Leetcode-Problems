class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        generateAllCombinations(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }
    
    private void generateAllCombinations(int arr[], int currentIndex, int target, List<Integer> currentAns, List<List<Integer>> ans){
        if(target <= 0 || currentIndex >= arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(currentAns));
            }
            return;
        }
        
        int currentValue = arr[currentIndex];
        currentAns.add(currentValue);
        generateAllCombinations(arr, currentIndex, target - currentValue, currentAns, ans);
        currentAns.remove(currentAns.size() - 1);
        generateAllCombinations(arr, currentIndex + 1, target, currentAns, ans);
        
        
    }
}