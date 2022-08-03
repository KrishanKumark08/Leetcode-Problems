class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        
        findAllPaths(graph, 0, ans, new ArrayList<>(), graph.length - 1);
        
        return ans;
        
    }
    
    private void findAllPaths(int[][] graph, int currentNode, List<List<Integer>> ans,  List<Integer> currAns, int destination){
        if(currentNode == destination){
            currAns.add(currentNode);
            ans.add(new ArrayList<>(currAns));
            currAns.remove(currAns.size() - 1);
        }
        
        currAns.add(currentNode);
        
        for(int neighbour : graph[currentNode]){
            findAllPaths(graph, neighbour, ans, currAns, destination);
        }
        
        currAns.remove(currAns.size() - 1);
        
        return;
        
    }
    
}