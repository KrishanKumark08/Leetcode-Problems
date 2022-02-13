class Pair {
    
    int x;
    int y;
    
    Pair( int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image[sr][sc] == newColor)
            return image;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add( new Pair(sr,sc));

        int color = image[sr][sc];
        
        while(queue.size()>0)
        {
            Pair current = queue.remove();
            int currentrow= current.x;
            int currentcol= current.y;
            
            if(currentrow<0 || currentrow>=image.length || currentcol<0 || currentcol>=image[0].length || image[currentrow][currentcol] != color)
                continue ;
            
                image[currentrow][currentcol] = newColor;
                queue.add( new Pair(currentrow-1,currentcol));
                queue.add( new Pair(currentrow+1,currentcol));
                queue.add( new Pair(currentrow,currentcol+1));
                queue.add( new Pair(currentrow,currentcol-1));
                
        }
        return image;
    }
}