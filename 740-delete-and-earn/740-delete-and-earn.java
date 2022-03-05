class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for(int i =0;i<nums.length;i++)
            sum=Math.max(sum,nums[i]);
        int[][] memo = new int[nums.length+1][sum+2];
        return deleteandearn(nums,0,sum+1,memo);
    }
    private int deleteandearn(int[] nums,int current,int val,int[][] memo)
    {
        if(current>=nums.length)
            return 0;
        
        
        if(memo[current][val]!=0)
            return memo[current][val];
        
        int consider=0,notconsider=0;
        if(nums[current]!=val+1)
        {
            consider = nums[current]+deleteandearn(nums,current+1,nums[current],memo);
        }
        
        notconsider= deleteandearn(nums,current+1,val,memo);
        
        memo[current][val] = Math.max(consider,notconsider);
        
        return memo[current][val];
    }
}