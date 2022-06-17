class Solution {
    public int subarraySum(int[] nums, int k) {
        int answer = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> memo = new HashMap<>();
        memo.put(prefixSum, 1);
        
        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];
            
            if(memo.containsKey(prefixSum - k)){
                answer += memo.get(prefixSum - k);
            }
            memo.put(prefixSum, memo.getOrDefault(prefixSum, 0) + 1);
            
           }
        
        return answer;
        
    }
}