class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        
        generateAllSubsets(nums, 0, powerSet, new ArrayList<>());
        
        return powerSet;
    }
    public void generateAllSubsets(int[] nums, int currentIndex, List<List<Integer>> powerSet, List<Integer> currentSubset)
    {
        if(currentIndex >= nums.length)
        {
            powerSet.add(new ArrayList<>(currentSubset));
            return ;
        }
        
        int currentVal = nums[currentIndex];
        currentSubset.add(nums[currentIndex]);
        
        generateAllSubsets(nums, currentIndex+1, powerSet, currentSubset);
        
        currentSubset.remove(currentSubset.size()-1);
        generateAllSubsets(nums, currentIndex+1, powerSet, currentSubset);
    }
}