class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return totalPaths(obstacleGrid, 0, 0, new HashMap<String, Integer>());
    }
    
    private int totalPaths(int[][] obstacleGrid, int row, int col, HashMap<String, Integer> memo){
        
        if(row < 0 || row >= obstacleGrid.length || col < 0 || col >= obstacleGrid[0].length || obstacleGrid[row][col] == 1){
            return 0;
        }
        
        if(row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1){
            return 1;
        }
        
        String currentKey = row + "_" + col;
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        
        int downMove = totalPaths(obstacleGrid, row + 1, col, memo);
        int rightMove = totalPaths(obstacleGrid, row, col + 1, memo);
        
        memo.put(currentKey, downMove + rightMove);
        return memo.get(currentKey);
        
    }
    
}