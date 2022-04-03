class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length-1;
        boolean flag = false;
        for(i = nums.length-1;i>0;i--)
        {
            if(nums[i] < nums[i-1])
                continue;
            else
            {
               // int ele = nums[i];
                Arrays.sort(nums,i,nums.length);
                for(int j=i;j<nums.length;j++)
                {
                    if(nums[i-1] < nums[j] )
                    {
                        int temp = nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j] = temp;
                        flag = true;
                        break;
                    }
                   
                }
            }
            if(flag)
                break;
        }
        if(i==0)
            Arrays.sort(nums);
    }
}