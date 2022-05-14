class Pair implements Comparable<Pair> {
    int vertex;
    int cost;
    Pair(int vertex , int cost)
    {
        this.vertex = vertex;
        this.cost = cost;
    }
    
    public int compareTo(Pair o){
        return this.cost-o.cost;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int V, int S) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        
        S= S;
        for(int i =0; i<=V ; i++)
            adj.add(new ArrayList<>());
        for(int[] i : times)
        {
            ArrayList<ArrayList<Integer>> arr = adj.get(i[0]);
            
            ArrayList <Integer> list = new ArrayList<>();
            list.add(i[1]);
            list.add(i[2]);
            
            arr.add(list);
        }
        
        for(ArrayList<ArrayList<Integer>> o : adj)
        System.out.println(o);
        PriorityQueue <Pair> pq = new PriorityQueue<>();
        int costs[] = new int[V+1];
        
        pq.add(new Pair(S,0));
        
        HashSet<Integer> visited = new HashSet<>();
        
        int count = 0;
        int max = 0;
        while(pq.size() > 0){
            Pair cn = pq.remove();
            
            int cc = cn.cost;
            int current = cn.vertex;
            
            if(visited.contains(current))
            continue;
            
            visited.add(current);
            costs[current] = cc;
            max = Math.max(max , cc);
            count++;
            for(ArrayList<Integer> i : adj.get(current))
            {
                if(!visited.contains(i.get(0)))
                pq.add(new Pair(i.get(0) , cc+i.get(1)));
            }
            
        }
        
        // int count = 0;
        // for(int i : costs)
        // {
        //     if(i == 0)
        //         count++;
        // }
        
        if(count == V)
        return max;
        
        return -1;
    }
}