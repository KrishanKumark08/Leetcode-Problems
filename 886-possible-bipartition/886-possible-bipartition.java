class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < dislikes.length; i++){
            int u = dislikes[i][0];
            int v = dislikes[i][1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
            
        }
        
        int[] colors = new int[n+1];
        Arrays.fill(colors, -1);
        
        // We are running the for Loop only to handle the disconnected graph
        
        for(int currentVertex = 1; currentVertex <= n; currentVertex++){
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
    
    private boolean checkIfBipartite(List<List<Integer>> graph, int[] colors, int currentVertex, int color){
        if(colors[currentVertex] != -1){
            return colors[currentVertex] == color;
        }
        
        colors[currentVertex] = color;
        
        for(int neighbour:graph.get(currentVertex)){
            if(checkIfBipartite(graph, colors, neighbour, 1 - color) == false){
                return false;
            }
        }
        
        return true;
    }
}