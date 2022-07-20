class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currAns = new ArrayList<>();
        currAns.add(0);
        
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(currAns);
        
        while(!queue.isEmpty()){
            currAns = queue.remove();
            
            int currentNode = currAns.get(currAns.size() - 1);
            if(currentNode == graph.length - 1){
                ans.add(currAns);
                continue;   
            }
            
            for(int neighbour:graph[currentNode]){
                List<Integer> newList = new ArrayList<>(currAns);
                newList.add(neighbour);
                queue.add(newList);
            }
        }
        return ans;
    }
}