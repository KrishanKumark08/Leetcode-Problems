class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currAns = new ArrayList<>();
        currAns.add(0);
        
        allPaths(graph, 0, currAns, ans);
        
        return ans;
    }
    
    private void allPaths(int[][] graph, int currentNode, List<Integer> currAns, List<List<Integer>> ans){
        if(currentNode == graph.length - 1){
            ans.add(new ArrayList<>(currAns));
            return;
        }
        
        for(int i = 0; i < graph[currentNode].length; i++){
            currAns.add(graph[currentNode][i]);
            allPaths(graph, graph[currentNode][i], currAns, ans);
            currAns.remove(currAns.size() - 1);
        }
        
    }
    
}