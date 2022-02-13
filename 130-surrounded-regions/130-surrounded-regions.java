class Solution {
    public void solve(char[][] grid) {
        
        boolean[][] arr=new boolean[grid.length][grid[0].length];
        for(boolean[] j : arr)
            Arrays.fill(j,true);
        
        // For edges
        for(int j=0;j<grid[0].length ; j++)
        {
                filcolor(grid, 0, j,arr);
                filcolor(grid, grid.length-1, j,arr);
                filcolor(grid, j, 0,arr);
                filcolor(grid,j,grid[0].length-1,arr);
        }
        
        
        for(int i=1; i<grid.length-1;i++)
        {
            for(int j=1;j<grid[0].length-1 ; j++)
            {
                if( grid[i][j] == 'O'&& arr[i][j]==true)
                {
                    fillcolor(grid, i, j);
                }
            }
        }
        
        return ;
    }
    
     private void fillcolor(char[][] image, int sr, int sc)
    {
        if(sr <= 0 || sr>=image.length-1 || sc<=0 || sc>=image[0].length-1)
            return ;
        
       //  int i=0,j=0,g=0,h=0;
        if(image[sr][sc] == 'O' )
        {
            image[sr][sc]='X';
            
            fillcolor(image,sr+1,sc);
            fillcolor(image,sr-1,sc);
            fillcolor(image,sr,sc+1);
            fillcolor(image,sr,sc-1);
        }
    }
    
    
    private void filcolor(char[][] image, int sr, int sc, boolean grid[][])
    {
        if(sr < 0 || sr>= image.length || sc<0 || sc>=image[0].length)
            return ;
        
        if(image[sr][sc] == 'O' && grid[sr][sc]==true)
        {
            grid[sr][sc]=false;
            filcolor(image,sr+1,sc,grid);
            filcolor(image,sr-1,sc,grid);
            filcolor(image,sr,sc+1,grid);
            filcolor(image,sr,sc-1,grid);
        }
    }
}