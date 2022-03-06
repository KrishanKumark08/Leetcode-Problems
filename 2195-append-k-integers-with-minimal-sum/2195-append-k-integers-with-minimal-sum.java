class Solution {
    public long minimalKSum(int[] nums, int k) {
        long sum = 0;
        long last = 1;
        int i = 0;
        Arrays.sort(nums);
        while(i < nums.length && k != 0){
            if(nums[i] > last){
                long current = Math.min(nums[i] - last, k);
                sum += (last + current - 1)*(last + current)/2 - (last - 1)*(last)/2;
                k -= current;
                last = nums[i];
            }
            else if(nums[i] == last){
                last++;
                i++;
            }
            else{
                i++;
            }
        }
        
        while(k != 0){
            sum += last;
            last++;
            k--;
        }
        
        return sum;
    }
}