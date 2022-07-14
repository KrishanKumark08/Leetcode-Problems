class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        for(int j = 0; j < n; j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        
        for(int i = n - 2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int diag = triangle.get(i).get(j) + dp[i + 1][j + 1];
                
                dp[i][j] = Math.min(down, diag);
                
            }
        }
        
        return dp[0][0];
        
        //return minPath(0, 0, triangle,new HashMap<String, Integer>());
    }
//     public int minPath(int currentRow, int currentCol, List<List<Integer>> triangle, HashMap<String, Integer> memo){
//         if(currentRow >= triangle.size() || currentRow >= triangle.get(currentRow).size()){
//             return 0;
//         }
//         if(currentRow == triangle.size() - 1){
//             return triangle.get(currentRow).get(currentCol);   
//         }
        
//         String currentKey = currentRow + "_" + currentCol;
//         if(memo.containsKey(currentKey))
//             return memo.get(currentKey);
        
//         int i = triangle.get(currentRow).get(currentCol) + minPath(currentRow + 1, currentCol, triangle, memo);
        
//         int iPlusOne = triangle.get(currentRow).get(currentCol) + minPath(currentRow + 1, currentCol + 1, triangle, memo);
        
//         memo.put(currentKey, Math.min(i, iPlusOne));
//         return memo.get(currentKey);
        
//     }
}