class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        combinations(candidates,target,0,new ArrayList<>(),list);
        return list;
    }
    public void combinations(int[] nums, int target,int n,ArrayList<Integer>arr,
                             List<List<Integer>> list)
    {
        if(target==0)
        {
            list.add(new ArrayList(arr));
            return;
        }
        if(n>=nums.length)
            return;
        if(nums[n]<=target)
        {
            arr.add(nums[n]);
            combinations(nums,target-nums[n],n,arr,list);
            arr.remove(arr.size()-1);
        }
        combinations(nums,target,n+1,arr,list);
        return;
    }
}