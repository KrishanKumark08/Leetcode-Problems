class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        
        // We are running the for Loop only to handle the disconnected graph
        
        for(int currentVertex = 0; currentVertex < n; currentVertex++){
            if(colors[currentVertex] != -1){
                continue;
            }
            else{
                if(checkIfBipartite(graph, colors, currentVertex, 0) == false){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean checkIfBipartite(int[][] graph, int[] colors, int currentVertex, int color){
        if(colors[currentVertex] != -1){
            return colors[currentVertex] == color;
        }
        
        colors[currentVertex] = color;
        
        for(int neighbour:graph[currentVertex]){
            if(checkIfBipartite(graph, colors, neighbour, 1 - color) == false){
                return false;
            }
        }
        
        return true;
    }
}