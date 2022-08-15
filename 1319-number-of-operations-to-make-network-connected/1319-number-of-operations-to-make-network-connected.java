class Solution {
    public int makeConnected(int n, int[][] connections) {
        int numberOfConnectedComponents = 0;
        
        HashSet<Integer> visited = new HashSet<>();
        
        List<List<Integer>> graph = createGraph(n, connections);
        
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                numberOfConnectedComponents++;
                runDFS(i, visited, graph);
            }
        }
        
        if(connections.length >= n - 1)
            return numberOfConnectedComponents - 1;
        
        return -1;
        
        
    }

    private void runDFS(int currentVertex, HashSet<Integer> visited, List<List<Integer>> graph){
        if(visited.contains(currentVertex)){
            return;
        }
        
        visited.add(currentVertex);
        for(int neigh : graph.get(currentVertex)){
            runDFS(neigh, visited, graph);
        }
        
    }
    
    private List<List<Integer>> createGraph(int n, int[][] connections){
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        return graph;
        
    }
    
}