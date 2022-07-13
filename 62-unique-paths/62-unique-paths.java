class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] memo = new int[m][n];
        
        memo[m-1][n-1] = 1;
        
        for(int i = m - 1; i >=0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i + 1 < m){
                    memo[i][j] += memo[i + 1][j]; // Down
                }
                
                if(j + 1 < n){
                    memo[i][j] += memo[i][j+1]; // Right
                }
            }
        }
        
        return memo[0][0];        
        
        //return totalPaths(m, n, 0, 0, new HashMap<>());
    }
    
//     private int totalPaths(int row, int col, int currentRow, int currentCol, HashMap<String, Integer> memo){
//         if(currentRow >= row || currentCol >= col){
//             return 0;
//         }
        
//         if(currentRow == row - 1 && currentCol == col - 1){
//             return 1;
//         }
        
//         String currentKey = currentRow + "_" + currentCol;
        
//         if(memo.containsKey(currentKey)){
//             return memo.get(currentKey);
//         }
        
//         int right = totalPaths(row, col, currentRow, currentCol + 1, memo);
//         int down = totalPaths(row, col, currentRow + 1, currentCol, memo);
        
//         memo.put(currentKey, right + down);
//         return right + down;
        
        
//     }
    
}