class Pair implements Comparable<Pair>{
    int vertex;
    int time;
    
    Pair(int vertex, int time){
        this.vertex = vertex;
        this.time = time;
    }
    
    public int compareTo(Pair o){
        return this.time - o.time;
    }
    
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        HashSet<Integer> visited = new HashSet<>();
        //int[] times = new int[n];
        
        queue.add(new Pair(k, 0));
        int answer = -1;
        while(queue.size() > 0){
            Pair currentPair = queue.remove();
            int currentVertex = currentPair.vertex;
            int currentTime = currentPair.time;
            
            if(visited.contains(currentVertex)){
                continue;
            }
            
            visited.add(currentVertex);
            answer = Math.max(answer, currentTime);
            
            for(int i = 0; i < times.length;i++){
                if(times[i][0] == currentVertex){
                    if(!visited.contains(times[i][1]))
                    queue.add(new Pair(times[i][1], times[i][2] + currentTime));
                }
            }  
        }
        
        if(visited.size() == n){
            return answer;
        }
        
        return -1;
    }
}