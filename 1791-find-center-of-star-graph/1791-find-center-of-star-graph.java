class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int inDegree[] = new int[n+1];
        
        for(int i = 0; i < n - 1;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            inDegree[u]++;
            inDegree[v]++;
            
        }
        
        for(int i = 1; i <= n; i++){
            if(inDegree[i] == n - 1){
                return i;
            }
        }
        
        return -1;
        
    }
}