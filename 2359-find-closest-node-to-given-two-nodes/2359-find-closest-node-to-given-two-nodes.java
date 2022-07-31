class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        
        int[] ds1 = new int[n];
        Arrays.fill(ds1, n);
        
        int count1 = 0;
        
        while(node1 != -1 && ds1[node1] == n){
            ds1[node1] = count1++;
            node1 = edges[node1];
        }
        
        int[] ds2 = new int[n];
        Arrays.fill(ds2, n);
        
        int count2 = 0;
        
        while(node2 != -1 && ds2[node2] == n){
            ds2[node2] = count2++;
            node2 = edges[node2];
        }
        
        
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
}