class Solution {
    public void rotate(int[] nums, int k) {
        HashSet<Integer> visited = new HashSet<>();
        
        for(int i = 0 ; i<nums.length ; i++)
        {
            if(!visited.contains(i))
                 rotateArray(nums , i ,nums[i], k , visited);
        }
       
        return ;
    }
    
    public void rotateArray(int[] nums ,int current,int prev,int k ,HashSet<Integer> visited){
        
        if(visited.contains(current))
        {
            nums[current] = prev;
            return;
        }
        
        int val = nums[current];
        nums[current] = prev;
        visited.add(current);
        
        rotateArray(nums, (current+k)%nums.length, val, k , visited);
        return;
    }
    
}