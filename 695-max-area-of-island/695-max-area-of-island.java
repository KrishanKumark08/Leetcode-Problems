class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int answer = 0;
        
        for(int currentRow = 0; currentRow < m; currentRow++){
            for(int currentCol = 0; currentCol < n; currentCol++){
                if(grid[currentRow][currentCol] == 1){
                    int currAns = sinkIsland(grid, currentRow, currentCol, m, n);
                    answer = Math.max(currAns, answer);
                }
            }
        }
        
        return answer;
    }
    
    private int sinkIsland(int[][] grid, int currentRow, int currentCol, int m, int n){
        if(currentRow < 0 || currentRow >= m || currentCol < 0 || currentCol >= n || grid[currentRow][currentCol] == 0){
            return 0;
        }
        
        grid[currentRow][currentCol] = 0;
        return 1 + sinkIsland(grid, currentRow - 1, currentCol, m, n) + sinkIsland(grid, currentRow, currentCol + 1, m, n) + sinkIsland(grid, currentRow + 1, currentCol, m, n) + sinkIsland(grid, currentRow, currentCol - 1, m, n);
        
    }
    
}