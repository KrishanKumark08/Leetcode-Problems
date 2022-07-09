class Solution {
    public int uniquePaths(int m, int n) {
        return totalPaths(m, n, 0, 0, new HashMap<>());
    }
    
    private int totalPaths(int row, int col, int currentRow, int currentCol, HashMap<String, Integer> memo){
        if(currentRow >= row || currentCol >= col){
            return 0;
        }
        
        if(currentRow == row - 1 && currentCol == col - 1){
            return 1;
        }
        
        String currentKey = currentRow + "_" + currentCol;
        
        if(memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        
        int right = totalPaths(row, col, currentRow, currentCol + 1, memo);
        int down = totalPaths(row, col, currentRow + 1, currentCol, memo);
        
        memo.put(currentKey, right + down);
        return right + down;
        
        
    }
    
}