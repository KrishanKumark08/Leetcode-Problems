class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph = createGraph(n, connections);
        return findCriticalConnections(n, graph);
    }
    
    private List<List<Integer>> findCriticalConnections(int n, List<Integer>[] graph){
        int[] discTime = new int[n];
        Arrays.fill(discTime, -1);
        
        int[] lowTime = new int[n];
        Arrays.fill(lowTime, -1);
        
        int[] time = {0};
        
        List<List<Integer>> ans = new ArrayList<>();
        
        tarjanDFS(graph, 0, -1, discTime, lowTime, time, ans);
        
        return ans;
        
    }
    
    private void tarjanDFS(List<Integer>[] graph, int currentVertex, int currentParent, int[] discTime, int[] lowTime, int[] time, List<List<Integer>> ans){
        discTime[currentVertex] = time[0];
        lowTime[currentVertex] = time[0];
        time[0]++;
        
        for(Integer neigh:graph[currentVertex]){
            if(neigh == currentParent){
                continue;
            }
            
            if(discTime[neigh] != -1){
                lowTime[currentVertex] = Math.min(lowTime[currentVertex], discTime[neigh]);
                continue;
            }
            
            tarjanDFS(graph, neigh, currentVertex, discTime, lowTime, time, ans);
            
            lowTime[currentVertex] = Math.min(lowTime[currentVertex], lowTime[neigh]);
            
            if(discTime[currentVertex] < lowTime[neigh]){
                List<Integer> temp = new ArrayList<>();
                temp.add(currentVertex);
                temp.add(neigh);
                ans.add(temp);
            }   
        }
        return;
    }
    
    
    private List<Integer>[] createGraph(int n, List<List<Integer>> edges){
        List<Integer>[] graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(List<Integer> edge:edges){
            int u = edge.get(0);
            int v = edge.get(1);
            
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }
    
}