class Pair implements Comparable<Pair>{
    int element;
    int count;
    Pair(int element, int count){
        this.element = element;
        this.count = count;
    }
    
    public int compareTo(Pair o){
        return this.count - o.count;
    }
    
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            memo.put(nums[i], memo.getOrDefault(nums[i], 0) + 1);
        }
        
        for(int key:memo.keySet()){
            pq.add(new Pair(key, memo.get(key)));
            if(pq.size() > k){
                pq.remove();
            }
        }
        
        int[] ans = new int[k];
        
        for(int i = k - 1; i >= 0; i--){
            Pair p = pq.remove();
            ans[i] = p.element;
        }
        
        return ans;
        
    }
}