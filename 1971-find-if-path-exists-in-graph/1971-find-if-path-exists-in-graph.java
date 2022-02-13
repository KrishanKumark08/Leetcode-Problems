class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //ArrayList<Integer>[] graph = new ArrayList[n];
        // HashMap<Integer, List<Integer>> graph = new HashMap<>();
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
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.add(source);
        
        while(queue.size() > 0){
            int currentNode = queue.remove();
            
            if(visited[currentNode]){
                continue;
            }
            
            if(currentNode == destination){
                return true;
            }
            
            visited[currentNode] = true;
            
            for(Integer neighbour:graph.get(currentNode)){
                queue.add(neighbour);
            }
            
        }
        
        return false;
        
        //return pathExists(n, graph, source, destination, new int[n]);
    }
    
//     private boolean pathExists(int n, List<List<Integer>> graph, int currentNode, int destination, int[] visited){
//         if(currentNode >= n || visited[currentNode] == 1){
//             return false;
//         }
        
//         if(currentNode == destination){
//             return true;
//         }
        
//         visited[currentNode] = 1;
        
//         boolean isPath = false;
//         for(int neighbour : graph.get(currentNode)){
//             isPath = isPath || pathExists(n, graph, neighbour, destination, visited);
//             if(isPath == true){
//                 return true;
//             }
//         }
        
//         visited[currentNode] = 0;
        
//         return isPath;
        
//     }
    
}