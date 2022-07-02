class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        
        for(int i = 0; i < n; i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            
            int front = i + 1;
            int back = n - 1;
            
            while(front < back){
                if(nums[front] + nums[back] < (-1)*nums[i]){
                    front++;
                }
                else if(nums[front] + nums[back] > (-1)*nums[i]){
                    back--;
                }
                else{
                    List<Integer> tri = new ArrayList<>(Arrays.asList(nums[i], nums[front], nums[back]));
                    res.add(tri);
                    front++;
                    back--;
                    while(front < back && nums[front] == nums[front - 1]) front++;
                    while(front < back && nums[back] == nums[back + 1]) back--;
                }
            }
            
        }
        return res;
    }
}