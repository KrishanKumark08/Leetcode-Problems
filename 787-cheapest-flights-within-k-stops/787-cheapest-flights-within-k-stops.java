class Solution {
    int ans = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] graph = new int[n][n];
        for(int i = 0; i < flights.length; i++){
            graph[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        
        int ans = operateCheapest(src, dst, graph, k + 1, new int[n+1][n+1][k+2]);
        
        if(ans == 1000000){
            return -1;
        }
        return ans;
    }
    
    private int operateCheapest(int currentVertex, int destination, int[][] graph, int k, int[][][] dp){
        if(currentVertex == destination){
            return 0;
        }
        
        if(k == 0){
            return 1000000;
        }
        
        if(dp[currentVertex][destination][k] != 0){
            return dp[currentVertex][destination][k];
        }
        
        int min = 1000000;
        
        for(int i = 0; i < graph[currentVertex].length; i++){
            if(graph[currentVertex][i] != 0){
                min = Math.min(min, graph[currentVertex][i] + operateCheapest(i, destination, graph, k - 1, dp));
            }
        }
                 dp[currentVertex][destination][k] = min;
                               return min;             
    }
    
}
        