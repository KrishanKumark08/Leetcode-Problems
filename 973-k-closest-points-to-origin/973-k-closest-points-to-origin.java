class Pair implements Comparable<Pair>{
    int x;
    int y;
    double distance;
    Pair(int x, int y, double distance){
        this.x = x;
        this.y = y;
        this.distance = distance;
    }
    
    public int compareTo(Pair o){
        if(this.distance > o.distance){
            return 1;
        }
        else if(this.distance < o.distance){
            return -1;
        }
        
        return 0;
    }
    
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < points.length; i++){
            pq.add(new Pair(points[i][0], points[i][1], Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2))));
            
            if(pq.size() > k){
                pq.remove();
            }   
        }
        
        int[][] ans = new int[k][2];
        
        int i = 0;
        while(!pq.isEmpty()){
            Pair pair = pq.remove();
            ans[i][0] = pair.x;
            ans[i][1] = pair.y;
            i++;
        }
        return ans;
    }
}