class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        
        int destination = graph.length - 1;
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> currAns = new ArrayList<>();
        currAns.add(0);
        queue.add(currAns);
        
        while(!queue.isEmpty()){
            currAns = queue.remove();
            
            int currNode = currAns.get(currAns.size() - 1);
            
            if(currNode == destination){
                ans.add(new ArrayList<>(currAns));
                continue;
            }
            
            for(int neighbour : graph[currNode]){
                currAns.add(neighbour);
                queue.add(new ArrayList<>(currAns));
                currAns.remove(currAns.size() - 1);
            }
            
        }
        
        return ans;
        
    }
}