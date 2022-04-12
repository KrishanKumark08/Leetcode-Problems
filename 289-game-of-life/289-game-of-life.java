class Solution {
    public int findNeighbour(int x, int y, int[][] board, int m, int n){
        int cnt=0;
        if(x-1>=0 && (board[x-1][y]==1 || board[x-1][y]==3)) cnt++;
        if(x+1<m && board[x+1][y]==1) cnt++;
        if(y-1>=0 && (board[x][y-1]==1 || board[x][y-1]==3)) cnt++;
        if(y+1<n && board[x][y+1]==1) cnt++;
        if(x-1>=0 && y-1>=0 && (board[x-1][y-1]==1 || board[x-1][y-1]==3)) cnt++;
        if(x-1>=0 && y+1<n && (board[x-1][y+1]==1 || board[x-1][y+1]==3)) cnt++;
        if(x+1<m && y-1>=0 && board[x+1][y-1]==1) cnt++;
        if(x+1<m && y+1<n && board[x+1][y+1]==1) cnt++;
        return cnt;
    }
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int k=findNeighbour(i, j, board, m, n);
                if(board[i][j]==0 && k==3) board[i][j]=2;
                else if(board[i][j]==1 && (k<2 || k>3)) board[i][j]=3;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==3) board[i][j]=0;
                else if(board[i][j]==2) board[i][j]=1;
            }
        }
    }
}