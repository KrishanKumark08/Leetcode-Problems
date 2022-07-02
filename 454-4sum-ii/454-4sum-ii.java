class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        int count = 0;
        
        for(int e1:nums1){
            for(int e2:nums2){
                memo.put(e1 + e2, memo.getOrDefault(e1 + e2, 0) + 1);
            }
        }
        
        int target = 0;
        for(int e1:nums3){
            for(int e2:nums4){
                count += memo.getOrDefault(target - (e1 + e2), 0);
            }
        }
        
        return count;
        
    }
}