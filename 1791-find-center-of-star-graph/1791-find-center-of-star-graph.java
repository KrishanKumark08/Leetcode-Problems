class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length + 1;
        int[] inDegree = new int[n+1];
        
        for(int i = 0; i < edges.length; i++){
            int ai = edges[i][0];
            int bi = edges[i][1];
            
            inDegree[bi]++;
            inDegree[ai]++;
            
        }
        
        for(int i = 1; i < n+1; i++){
            if(inDegree[i] == n - 1){
                return i;
            }
        }
        return -1;
    }
}