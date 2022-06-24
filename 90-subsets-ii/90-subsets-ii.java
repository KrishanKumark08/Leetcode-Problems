class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        List<Integer> currentAns = new ArrayList<>();
        calcSubsets(nums, 0, currentAns, set);
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    } 
    
    private void calcSubsets(int nums[], int currentIndex, List<Integer> currentAns, HashSet<List<Integer>> set){
        if(currentIndex >= nums.length){
            set.add(new ArrayList<>(currentAns));
            return;
        }
        
        currentAns.add(nums[currentIndex]);
        calcSubsets(nums, currentIndex + 1, currentAns, set);
        currentAns.remove(currentAns.size() - 1);
        calcSubsets(nums, currentIndex + 1, currentAns, set);   
    }
}