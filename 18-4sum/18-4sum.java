class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        int n = nums.length;
        
        for(int i = 0; i < n; i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n; j++){
                if(j != i + 1 && nums[j] == nums[j - 1]) continue;
                int front = j + 1;
                int back = n - 1;
                
                while(front < back){
                    long sum = (long)nums[i] + nums[j] + nums[front] + nums[back];
                    if(sum > target){
                        back--;
                    }
                    else if(sum < target){
                        front++;
                    }
                    else{
                        List<Integer> quad = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[front], nums[back]));
                        res.add(quad);
                        
                        front++;
                        back--;
                        while(front < back && nums[front] == nums[front - 1]) front++;
                        while(front < back && nums[back] == nums[back + 1]) back--;
                        
                    }
                }
                
            }
        }
        return res;
    }
}