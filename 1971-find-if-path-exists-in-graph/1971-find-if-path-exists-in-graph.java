class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // DFS
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++){
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
            
        }
        return ifPathExists(n, graph, source, destination, new int[n]);
    }
    
    private boolean ifPathExists(int n, List<List<Integer>> graph, int source, int destination, int[] visited){
        if(visited[source] == 1){
            return false;
        }
        
        if(source == destination){
            return true;
        }
        
        visited[source] = 1;
        
        for(int neighbour:graph.get(source)){
            if(ifPathExists(n, graph, neighbour, destination, visited)){
                return true;
            }
        }
        
        return false;
    }
}
    