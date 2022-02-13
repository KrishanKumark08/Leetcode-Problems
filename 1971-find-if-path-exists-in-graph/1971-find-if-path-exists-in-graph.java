class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // DFS
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i =0; i < n; i++)
        {
            graph.add(new ArrayList<>());
        }
        
        for(int i=0; i < edges.length; i++){
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
            
        }
        
        return pathExists(n, graph, source, destination, new int[n]);
           
    }
    
        private boolean pathExists(int n, List<List<Integer>> graph, int currentNode, int destination, int[] visited){
        if(visited[currentNode] == 1){
            return false;
        }
        
        if(currentNode == destination){
            return true;
        }
        
        visited[currentNode] = 1;
        
        boolean isPath = false;
        for(int neighbour : graph.get(currentNode)){
            if(pathExists(n, graph, neighbour, destination, visited)){
                return true;
            }
        }
        
        return isPath;
        
    }
    
}