class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<ArrayList<Integer>> graph = createGraph(n, prerequisites);
        
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> recStack = new HashSet<>();
        List<Integer> traversal = new ArrayList<>();
        
        for(int currentVertex = 0; currentVertex < n; currentVertex++){
            
            if(visited.contains(currentVertex)){
                continue;
            }
            
            if(isCyclic(graph, currentVertex, visited, recStack, traversal)){
                return false;
            }
        }
        
        return true;
        
    }
    
    private boolean isCyclic(List<ArrayList<Integer>> graph, int currentVertex, HashSet<Integer> visited, HashSet<Integer> recStack, List<Integer> traversal){
        visited.add(currentVertex);
        recStack.add(currentVertex);
        
        for(Integer neighbour:graph.get(currentVertex)){
            if(!visited.contains(neighbour)){
                if(isCyclic(graph, neighbour, visited, recStack, traversal)){
                    return true;
                }
            }
            else if(recStack.contains(neighbour)){
                return true;
            }
        }
        
        traversal.add(currentVertex);
        recStack.remove(currentVertex);
        return false;
        
    }
    
    private List<ArrayList<Integer>> createGraph(int n, int[][] edges){
        List<ArrayList<Integer>> graph = new ArrayList<>(n);
        
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int[] edge:edges){
            int v = edge[0];
            int u = edge[1];
            graph.get(u).add(v);
        }
        
        return graph;
        
    }
    
}