class Pair implements Comparable<Pair>{
    int vertex;
    int cost;
    Pair(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }
    
    public int compareTo(Pair o){
        return this.cost - o.cost;
    }
    
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashSet<Integer> visited = new HashSet<>();
        
        pq.add(new Pair(k, 0));
        
        int ans = -1;
        
        while(!pq.isEmpty()){
            Pair currentPair = pq.remove();
            int currentVertex = currentPair.vertex;
            int currentCost = currentPair.cost;
            
            if(visited.contains(currentVertex))
                continue;
            
            visited.add(currentVertex);
            ans = Math.max(ans, currentCost);
            
            for(int i = 0; i < times.length; i++){
                if(times[i][0] == currentVertex){
                    if(!visited.contains(times[i][1])){
                        pq.add(new Pair(times[i][1], times[i][2] + currentCost));
                    }
                }
            }
        }
        if(visited.size() == n){
            return ans;
        }
        return -1;
    }
}