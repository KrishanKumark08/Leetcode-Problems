class Solution {
    public int searchInsert(int[] nums, int target) {
        int ceil = findCeil(nums, nums.length, target);
        
        if(ceil == -1){
            return nums.length;
        }
        
        return ceil;
        
    }
    
    private int findCeil(int nums[], int n, int target)
    {
        int start = 0;
        int end = n - 1;
        int ans = -1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }
            
            if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }
    
}
