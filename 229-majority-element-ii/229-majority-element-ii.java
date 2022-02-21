class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],1 + map.getOrDefault(nums[i], 0));
        }
        
        for(Integer i:map.keySet()){
            if(map.get(i) > nums.length / 3){
                answer.add(i);
            }
        }
        
        return answer;
        
    }
}