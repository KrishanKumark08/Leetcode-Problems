class Solution {
    public boolean exist(char[][] board, String word) {
        for(int currentRow = 0; currentRow < board.length; currentRow++){
            for(int currentCol = 0; currentCol < board[0].length; currentCol++){
                if(word.charAt(0) == board[currentRow][currentCol]){
                     if(wordExists(board, word, 0, currentRow, currentCol, new boolean[board.length + 1][board[0].length + 1])){
                    return true;
                    }
                }
                   
            }
        }
       return false; 
    }
    
    private boolean wordExists(char[][] board, String word, int currentIndex, int currentRow, int currentCol, boolean[][] visited){
        
        if(currentIndex == word.length()){
            return true;
        }
        
        if(currentRow < 0 || currentRow >= board.length || currentCol < 0 ||currentCol >= board[0].length || visited[currentRow][currentCol] == true || board[currentRow][currentCol] != word.charAt(currentIndex)){
            return false;
        }
        
        visited[currentRow][currentCol] = true;
        
        boolean up = wordExists(board, word, currentIndex + 1, currentRow - 1, currentCol, visited);
        boolean right = wordExists(board, word, currentIndex + 1, currentRow, currentCol + 1, visited);
        boolean down = wordExists(board, word, currentIndex + 1, currentRow + 1, currentCol, visited);
        boolean left = wordExists(board, word, currentIndex + 1, currentRow, currentCol - 1, visited);
        
        visited[currentRow][currentCol] = false;
        
        return up || right || down || left;
        
    }
    
}