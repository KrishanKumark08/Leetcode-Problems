class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int stone:stones){
            pQueue.offer(stone);
        }
        
        while(pQueue.size() > 1){
            int x = pQueue.poll();
            int y = pQueue.poll();
            
            pQueue.offer(Math.abs(x - y));
            
        }
        
        return pQueue.peek();
        
    }
}