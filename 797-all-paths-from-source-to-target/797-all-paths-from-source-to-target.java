class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        currList.add(0);
        
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(currList);
        
        while(!queue.isEmpty()){
            currList = queue.remove();
            
            int v = currList.get(currList.size() - 1);
            
            if(v == graph.length - 1){
                ans.add(currList);
                continue;
            }
            
            for(int neighbour:graph[v]){
                List<Integer> newList = new ArrayList<>(currList);
                newList.add(neighbour);
                queue.add(newList);
            }
        }
        return ans;
    }
}