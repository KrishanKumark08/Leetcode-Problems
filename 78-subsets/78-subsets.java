class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> arr=new ArrayList<>();
        subset(nums,0,arr,new ArrayList<>());
        return arr;
    }
    public void subset(int[] nums,int n,List<List<Integer>> arr,List<Integer> list)
    {
        if(n==nums.length)
        {
            arr.add(new ArrayList<>(list));
           //  for(List<Integer> r:arr)
           //  {
           // for(int i:r)
           //     System.out.print(i+" ");
           //  System.out.println();
           //  }
            return ;
        }
       // ArrayList<Integer> list2=new ArrayList<>(list);
        list.add(nums[n]);
        subset(nums,n+1,arr,list);
        list.remove(list.size()-1);
        subset(nums,n+1,arr,list);
    }
}