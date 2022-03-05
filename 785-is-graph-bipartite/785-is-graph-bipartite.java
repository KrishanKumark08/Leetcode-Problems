class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        
        for(int currentVertex = 0; currentVertex < n; currentVertex++){
            
            if(colors[currentVertex] != -1){
                continue;
            }
            
            if(hasEvenLengthCycle(graph, currentVertex, 0, colors) == false){
                return false;
            }
            
        }
        return true;
    }
    
    private boolean hasEvenLengthCycle(int[][] graph, int currentVertex, int color, int[] colors){
        if(colors[currentVertex] != -1){
            return colors[currentVertex] == color;
        }
        
        colors[currentVertex] = color;
        
        for(int neigh:graph[currentVertex]){
            if(hasEvenLengthCycle(graph, neigh, 1- color, colors) == false){
                return false;
            }
        }
        return true;
    }
    
}