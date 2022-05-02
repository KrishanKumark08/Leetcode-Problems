class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] ans = new int[nums.length];
        
        int j = 0;
        
        for(int i = 0;i < nums.length - 1;i++){
            if(nums[i] % 2 != 0){
                j = i;
                while(j < nums.length && nums[j] % 2 != 0){
                    j++;
                }
                
                if(j >= nums.length){
                    break;
                }
                
                System.out.println("nums[i] = "+nums[i]+" j = "+j);
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return nums;
    }
}