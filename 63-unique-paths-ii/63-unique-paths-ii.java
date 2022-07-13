class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        
        memo[m-1][n-1] = 1;
        
        for(int i = m - 1; i >=0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(obstacleGrid[i][j] == 1){
                    memo[i][j] = 0;
                    continue;
                }
                if(i + 1 < m){
                    memo[i][j] += memo[i + 1][j];
                }
                
                if(j + 1 < n){
                    memo[i][j] += memo[i][j+1];
                }
            }
        }
        
        return memo[0][0];
    }
    
}