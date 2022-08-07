class Pair implements Comparable<Pair>{
    int absoluteDiff;
    int index;
    Pair(int absoluteDiff, int index){
        this.absoluteDiff = absoluteDiff;
        this.index = index;
    }
    
    public int compareTo(Pair o){
        if(this.absoluteDiff != o.absoluteDiff)
            return this.absoluteDiff - o.absoluteDiff;
        return this.index - o.index;
    }
    
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < arr.length; i++){
            pq.add(new Pair(Math.abs(x - arr[i]), i));    
        }
        
        while(pq.size() > k){
            pq.remove();
        }
        
        List<Integer> ans = new ArrayList<>();
        while(pq.size() > 0){
            Pair p = pq.remove();
            ans.add(arr[p.index]);
        }
        
        Collections.sort(ans);
        
        return ans;
        
    }
}