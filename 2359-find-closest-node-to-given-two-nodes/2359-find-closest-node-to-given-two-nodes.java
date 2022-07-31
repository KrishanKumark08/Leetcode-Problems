class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] ds1 = calculateDistances(edges, node1);
        int[] ds2 = calculateDistances(edges, node2);
        
        int n = edges.length;
        int ans = -1;
        int minDis = n;
        for(int i = 0; i < n; i++){
            int currDis = Math.max(ds1[i], ds2[i]);
            if(currDis < minDis){
                ans = i;
                minDis = currDis;
            }
        }
        return ans;
    }
    
    private int[] calculateDistances(int[] edges, int node){
        int n = edges.length;
        int[] ds = new int[n];
        Arrays.fill(ds, n);
        for(int d = 0; node >= 0 && ds[node] == n; node = edges[node]){
            ds[node] = d++;
        }
        return ds;
    }
    
}