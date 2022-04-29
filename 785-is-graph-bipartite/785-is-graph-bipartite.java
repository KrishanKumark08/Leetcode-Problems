class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors,-1);
        for(int i =0;i<graph.length;i++)
        {
            if(colors[i]==-1)
            {
       if( bipartite(graph,i,0,colors)==false)
           return false;
            }
        }
        return true;
    }
    private boolean bipartite(int[][] graph,int current,int color,int[] colors)
    {
        if(colors[current]!=-1)
        {
            if(color == colors[current])
                return true;
            return false;
        }
        
        colors[current] = color;
        for(int neighbour: graph[current])
        {
           if(bipartite(graph,neighbour,Math.abs(color-1),colors)==false)
               return false;
        }
        return true;
    }
}