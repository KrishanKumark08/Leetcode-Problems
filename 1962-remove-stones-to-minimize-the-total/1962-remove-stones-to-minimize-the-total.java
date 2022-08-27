class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int pile : piles){
            pq.add(pile);
        }
        
        while(k-- > 0){
            int top = pq.remove();
            int x = (int)(Math.ceil((double)top / 2.0));
            pq.add(x);
        }
        
        int sum = 0;
        while(!pq.isEmpty()){
            int top = pq.remove();
            sum += top;
        }
        
        return sum;
        
    }
}