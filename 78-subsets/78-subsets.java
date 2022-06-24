class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currentAns = new ArrayList<>();
        calcSubsets(nums, 0, currentAns, ans);
        return ans;
    } 
    
    private void calcSubsets(int nums[], int currentIndex, List<Integer> currentAns, List<List<Integer>> ans){
        if(currentIndex >= nums.length){
            ans.add(new ArrayList<>(currentAns));
            return;
        }
        
        currentAns.add(nums[currentIndex]);
        calcSubsets(nums, currentIndex + 1, currentAns, ans);
        currentAns.remove(currentAns.size() - 1);
        calcSubsets(nums, currentIndex + 1, currentAns, ans);   
    }
}