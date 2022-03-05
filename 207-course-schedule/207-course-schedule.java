class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph =new ArrayList<ArrayList<Integer>> ();
        
        for(int i=0;i < numCourses ; i++)
        {
            graph.add(i,new ArrayList<>());
        }
        
        for(int i = 0;i < prerequisites.length; i++)
        {
            ArrayList<Integer> arr = graph.get(prerequisites[i][0]);
            arr.add(prerequisites[i][1]);
            graph.set(prerequisites[i][0],arr);
        }
        
        return  isCyclic(numCourses,  graph);
    }
     public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> graph) {
        // code here
        int[] indegree = new int[graph.size()];
        for(int i = 0; i < graph.size(); i++)
        {
            for(int j : graph.get(i))
            indegree[j]++;
        }
        
        Queue<Integer> q= new LinkedList<>();
        
        for(int i =0; i<graph.size(); i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
         
        while(q.size()>0)
        {
            int cv = q.remove();
            for(int i : graph.get(cv))
            {
                indegree[i]--;
                if(indegree[i]==0)
                    q.add(i);
            }
        }
         
         
        for(int i =0; i<graph.size(); i++)
        {
            if(indegree[i]!=0)
            {
                return false;
            }
        }
        return true;
    }
}