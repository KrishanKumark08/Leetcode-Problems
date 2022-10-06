class Solution {
    public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
        ArrayList<Integer> r = new ArrayList<>();
        int ri = 0;
        // store index
        Deque < Integer > q = new ArrayDeque < > ();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            if (!q.isEmpty() && q.peek() == i - k) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }

            q.offer(i);
            if (i >= k - 1) {
                r.add( a[q.peek()]);
            }
        }
        
        int ans[] = new int[r.size()];
        for(int i = 0; i < r.size(); i++){
            ans[i] = r.get(i);
        }
        
        return ans;
    }
}