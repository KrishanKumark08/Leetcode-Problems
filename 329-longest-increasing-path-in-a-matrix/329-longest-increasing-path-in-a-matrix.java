class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int max = 0;
        HashMap<String, Integer> memo = new HashMap<>();
        for(int i = 0;i < matrix.length; i++){
            for(int j = 0;j<matrix[0].length; j++){
                max = Math.max(max, longest(matrix, i, j, -1, memo));
            }
        }
        if(max ==0){
            return 1;
        }
        return max;
    }
    
    private int longest(int[][] matrix, int currRow, int currCol, int prev, HashMap<String, Integer> memo){
        if(currRow < 0 || currRow >= matrix.length || currCol < 0 || currCol >= matrix[0].length){
            return -200;
        }
        
        String currKey = currRow + "_" + currCol + "_" + prev;
        if(memo.containsKey(currKey)){
            return memo.get(currKey);
        }
        
        int up = 0;
        int right = 0;
        int down = 0;
        int left = 0;
        
        if(matrix[currRow][currCol] > prev){
            up = 1 + longest(matrix, currRow - 1, currCol, matrix[currRow][currCol], memo);
            right = 1 + longest(matrix, currRow, currCol + 1, matrix[currRow][currCol], memo);
            down = 1 + longest(matrix, currRow + 1, currCol, matrix[currRow][currCol], memo);
            left = 1 + longest(matrix, currRow, currCol - 1, matrix[currRow][currCol], memo);
        }
        
        memo.put(currKey, Math.max(Math.max(up, right), Math.max(down, left)));
        return memo.get(currKey);
        
    }
    
}