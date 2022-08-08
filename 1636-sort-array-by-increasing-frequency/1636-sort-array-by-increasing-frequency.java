class Pair implements Comparable<Pair>{
    int element;
    int count;
    Pair(int element, int count){
        this.element = element;
        this.count = count;
    }
    
    public int compareTo(Pair o){
        if(this.count == o.count)
            return o.element - this.element;
        return this.count - o.count;
    }
    
}

class Solution {
    public int[] frequencySort(int[] nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            memo.put(nums[i], memo.getOrDefault(nums[i], 0) + 1);
        }
        
        for(int key:memo.keySet()){
            pq.add(new Pair(key, memo.get(key)));
        }
        
        int[] ans = new int[nums.length];
        int i = 0;
        
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int count = p.count;
            while(count-- > 0){
                ans[i] = p.element;
                i++;
            }
        }
        
        return ans;
        
    }
}

