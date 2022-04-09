class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int num:nums){
            list.add(num);
        }
        Collections.sort(list);
        Collections.reverse(list);
        return list.get(k-1);
    }
}