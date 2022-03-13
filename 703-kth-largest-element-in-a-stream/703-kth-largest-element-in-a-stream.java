class KthLargest {
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    int k;
    int kthMax = Integer.MIN_VALUE;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i:nums){
            queue.offer(i);
        }
        
        while (queue.size() > k) {
            queue.poll();
        }
        
    }
    
    public int add(int val) {
        queue.offer(val);
        while (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */