class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> answer = new ArrayList<>();
        
        if(nums.length == 0){
            return answer;
        }
        
        for(int i = 0; i < nums.length;i++){
            int start = nums[i];
            while(i + 1 < nums.length && nums[i + 1] == 1 + nums[i]){
                i++;
            }
            
            if(start != nums[i]){
                answer.add(""+start+"->"+nums[i]);
            }
            else{
                answer.add(""+start);
            }
        }
        
        return answer;
        
    }
}