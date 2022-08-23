class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();
        
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        
        int[][] memo = new int[c1.length][c2.length];
        
        for(int i = 0; i < c1.length; i++){
            for(int j = 0; j < c2.length; j++){
                memo[i][j] = -1;
            }
        }
        
        return minOperations(c1, c2, memo, 0, 0);
        
    }
    
    private int minOperations(char[] c1, char[] c2, int[][] memo, int i, int j){
        if(c1.length == i) return c2.length - j;
        if(c2.length == j) return c1.length - i;
        
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        
        if(c1[i] == c2[j]){
            memo[i][j] = minOperations(c1, c2, memo, i + 1, j + 1);
        }
        else{
            // insert
            int insert = minOperations(c1, c2, memo, i, j + 1);
            
            int delete = minOperations(c1, c2, memo, i + 1, j);
            
            int replace = minOperations(c1, c2, memo, i + 1, j + 1);
            
            memo[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
        }
        
        return memo[i][j];
        
    }
    
}