class Pair implements Comparable<Pair>{
    int x;
    int y;
    int cost;
    Pair(int x, int y, int cost){
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
    
    public int compareTo(Pair o){
        return this.cost - o.cost;
    }
    
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashSet<String> visited = new HashSet<>();
        
        int totalCost = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        int startX = points[0][0];
        int startY = points[0][1];
        pq.add(new Pair(startX, startY, 0));
        
        while(!pq.isEmpty()){
            Pair currentPair = pq.remove();
            int x = currentPair.x;
            int y = currentPair.y;
            int currentCost = currentPair.cost;
            
            String str = x + "_" + y;
            if(visited.contains(str)){
                continue;
            }
            
            totalCost += currentCost;
            visited.add(str);
            
            for(int[] point:points){
                int x1 = point[0];
                int y1 = point[1];
                
                String st = x1 + "_" + y1;
                if(visited.contains(st)){
                    continue;
                }
                
                pq.add(new Pair(x1, y1, Math.abs(x - x1) + Math.abs(y - y1)));
                
            }  
        }
        return totalCost;
    }
}