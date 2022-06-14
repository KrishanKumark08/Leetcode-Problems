class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                first = mid;
                end = mid - 1; // We will keep on looking for in left for first occurence
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        
        start = 0;
        end = nums.length - 1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                last = mid;
                start = mid + 1;// We will keep on looking for in right for first occurence
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        int ans[] = {first, last};
        
        return ans;
    }
}