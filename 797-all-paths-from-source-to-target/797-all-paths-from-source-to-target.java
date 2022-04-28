class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currAns = new ArrayList<>();
        allPaths(graph, 0, graph.length - 1, currAns, ans);
        return ans;
    }
    
    private void allPaths(int[][] graph, int src, int target, List<Integer> currAns, List<List<Integer>> ans){
        if(src == target){
            currAns.add(src);
            ans.add(new ArrayList<>(currAns));
            currAns.remove(currAns.size() - 1);
            return;
        }
        
        currAns.add(src);
        
        for(int i:graph[src]){
            allPaths(graph, i, target, currAns, ans);
        }
        currAns.remove(currAns.size() - 1);
        return;
    }
    
}