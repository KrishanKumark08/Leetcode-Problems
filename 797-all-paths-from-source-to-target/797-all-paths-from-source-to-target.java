class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // BFS
        List<List<Integer>> ans = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        
        List<Integer> curList = new ArrayList<>();
        curList.add(0);
        
        queue.add(curList);
        
        while(!queue.isEmpty()){
            curList = queue.remove();
            
            int v = curList.get(curList.size() - 1);
            
            if(v == graph.length - 1){
                ans.add(curList);
                continue;
            }
            
            for(int neighbour:graph[v]){
                List<Integer> newList = new ArrayList<>(curList);
                newList.add(neighbour);
                queue.add(newList);
            }
            
        }
        return ans;
    }
}