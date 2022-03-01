class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        //HashSet<Integer> answer = new HashSet<>();
        List<ArrayList<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            inDegree[prerequisites[i][0]]++;
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int ans = 0;
        
        for(int i = 0;i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.add(i);
                //answer.add(i);
                ans++;
            }
        }
        
        
        while(!queue.isEmpty()){
            int currentVertex = queue.remove();
            
            if(visited.contains(currentVertex)){
                continue;
            }
            
            visited.add(currentVertex);
            for(int neighbour:graph.get(currentVertex)){
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0){
                    queue.add(neighbour);
                    //answer.add(neighbour);
                    ans++;
                }
            }
        }
        
        return ans == numCourses;
        
    }
    
}