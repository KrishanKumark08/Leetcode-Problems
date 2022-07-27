class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
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
        
        return isValid(graph, source, destination, new int[n]);
        
    }
    
    private boolean isValid(List<List<Integer>> graph, int currentNode, int destination, int visited[]){
        if(visited[currentNode] == 1){
            return false;
        }
        
        if(currentNode == destination){
            return true;
        }
        
        visited[currentNode] = 1;
        boolean ans = false;
        for(int neigh:graph.get(currentNode)){
            boolean path = isValid(graph, neigh, destination, visited);
            ans = ans || path;
        }
        
        return ans;
        
    }
    
}