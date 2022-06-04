class Solution {
    public List<List<String>> solveNQueens(int n) {
       char[][] grid=new char[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                grid[i][j]='.';
        }
        List<List<String>> list=new ArrayList<>();
        Nqueens(n,0,grid,list);
        return list;
    }
    private void Nqueens(int n,int currentrow,char grid[][],List<List<String>> list)
    {
        if(currentrow==n)
        {
           List<String>ans=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                String temp=new String();
                for(int j=0;j<n;j++)
                {
                    temp=temp+grid[i][j];
                }
                ans.add(temp);
            }
           list.add(ans);
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(isvalid(grid,currentrow,i,n))
            {
                grid[currentrow][i]='Q';
                Nqueens(n,currentrow+1,grid,list);
                grid[currentrow][i]='.';
            }
        }
    }
    private boolean isvalid(char grid[][],int currentrow,int currentcol,int n)
    {
        return validrow(grid,n,currentrow)&& validcol(grid,n,currentcol)&&                                      validdia(grid,n,currentrow,currentcol);
    }
    private boolean validrow(char grid[][],int n,int currentrow)
    {
        for(int i=0;i<n;i++)
        {
            if(grid[currentrow][i]=='Q')
                return false;
        }
        return true;
    }
    private boolean validcol(char grid[][],int n,int currentcol)
    {
        for(int i=0;i<n;i++)
        {
            if(grid[i][currentcol]=='Q')
                return false;
        }
        return true;
    }
    private boolean validdia(char grid[][],int n,int currentrow,int currentcol)
    {
        int r=currentrow;
        int c=currentcol;
        while(r>=0&&c>=0)
        {
            if(grid[r][c]=='Q')
                return false;
            r--;
            c--;
        }
        r=currentrow;
        c=currentcol;
        while(r>=0&&c<n)
        {
            if(grid[r][c]=='Q')
                return false;
            r--;
            c++;
        }
        r=currentrow;
        c=currentcol;
        while(r<n&&c>=0)
        {
            if(grid[r][c]=='Q')
                return false;
            r++;
            c--;
        }
        r=currentrow;
        c=currentcol;
        while(r<n&&c<n)
        {
            if(grid[r][c]=='Q')
                return false;
            r++;
            c++;
        }
        return true;
    }
}