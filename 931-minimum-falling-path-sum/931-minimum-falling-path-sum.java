class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int dp[][] = new int[n][n];
        
        for(int j = 0; j < n; j++){
            dp[n - 1][j] = matrix[n - 1][j];
        }
        
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j < n; j++){
                int down = 1000000;
                int leftDiag = 1000000;
                int rightDiag = 1000000;
                
                if(j - 1 >= 0 && i + 1 < n){
                    leftDiag = dp[i + 1][j - 1];
                }
                
                if(i + 1 < n){
                    down = dp[i + 1][j];
                }
                
                if(j + 1 < n && i + 1 < n){
                    rightDiag = dp[i + 1][j + 1];
                }
                
                dp[i][j] = matrix[i][j] + Math.min(down, Math.min(leftDiag, rightDiag));
                
            }
        }
        
//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < n; j++){
//                 System.out.print(dp[i][j] + " ");
//             }
//             System.out.println();
//         }
        
        int min = Integer.MAX_VALUE;
        for(int temp:dp[0]){
            min = Math.min(min, temp); // As We Can Start from any block in 0th Row so answer can be 
                                        // present at any block
        }
        return min; 
        
        // int n = matrix.length;
        // int cost = Integer.MAX_VALUE;
        // int[][] memo = new int[n][n];
        // for(int i=0;i<matrix[0].length;i++){
        //     cost = Math.min(cost, minCost(0, i, matrix, n, memo));
        // }
        // return cost;
    }
//     public int minCost(int currentRow, int currentCol, int[][] matrix, int n, int[][] memo){
        
//         if(currentRow < 0 || currentRow >= n || currentCol < 0 || currentCol >= n )
//         return 10000;
        
//         if(currentRow==n-1){
//             return matrix[currentRow][currentCol];
//         }
            // TC : 3^(n*n) SC: Recursive Stack Space : O(n) TC is Exponential of Recursion
//         String currentKey = currentRow + "_" + currentCol;
//         if(memo[currentRow][currentCol]!=0){
//             return memo[currentRow][currentCol];
//         }
        
//         int downMove = matrix[currentRow][currentCol] + minCost(currentRow + 1, currentCol, matrix, n, memo);
        
//         int diagLeftMove = matrix[currentRow][currentCol] + minCost(currentRow + 1, currentCol - 1, matrix, n, memo);
        
//         int diagRightMove = matrix[currentRow][currentCol] + minCost(currentRow + 1, currentCol + 1, matrix, n, memo);
        
//         memo[currentRow][currentCol] =  Math.min(downMove, Math.min(diagLeftMove, diagRightMove));
        
//         return memo[currentRow][currentCol];
//     }
}