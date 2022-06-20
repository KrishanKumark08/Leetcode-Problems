class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> memo = new LinkedHashMap<>();
        int[] result = new int[2];
        
        for(int i = 0; i < nums.length; i++){
            int currentVal = nums[i];
            if(memo.containsKey(target - currentVal)){
                result[1] = i;
                result[0] = memo.get(target - currentVal);
                return result;
            }
            memo.put(currentVal, i);
        }
        return result;
    }
}