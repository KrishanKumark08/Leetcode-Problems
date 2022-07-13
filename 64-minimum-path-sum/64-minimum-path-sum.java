class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] memo = new int[m][n];
        
        memo[m-1][n-1] = grid[m-1][n-1];
        
        for(int i = m - 1; i >=0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 && j == n - 1){
                    continue;
                }
                
                int right = 1000;
                int down = 1000;
                
                if(i + 1 < m){
                    down = memo[i + 1][j];
                }
                
                if(j + 1 < n){
                    right = memo[i][j+1];
                }
                
                memo[i][j] = grid[i][j] + Math.min(right, down);
                
            }
        }
        
        return memo[0][0];        
        
    }
}