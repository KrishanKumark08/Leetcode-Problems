class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i, j));
                }
            }
        }
        
        int time = 0;
        
        while(!queue.isEmpty()){
            int currentSize = queue.size();
            
            boolean rotProcess = false;
            
            while(currentSize-- > 0){
                Pair pair = queue.remove();
                
                int x = pair.x;
                int y = pair.y;
                
                
                
                if(x > 0){
                    if(grid[x - 1][y] == 1){
                        rotProcess = true;
                        grid[x - 1][y] = 2;
                        queue.add(new Pair(x - 1, y));
                    }
                }
                
                if(x < m - 1){
                    if(grid[x+1][y] == 1){
                        rotProcess = true;
                        grid[x+1][y] = 2;
                        queue.add(new Pair(x + 1, y));
                    }
                }
                
                if(y > 0){
                    if(grid[x][y - 1] == 1){
                        rotProcess = true;
                        grid[x][y - 1] = 2;
                        queue.add(new Pair(x, y - 1));
                    }
                }
                
                if(y < n - 1){
                    if(grid[x][y + 1] == 1){
                        rotProcess = true;
                        grid[x][y + 1] = 2;
                        queue.add(new Pair(x, y + 1));
                    }
                }
            }
            if(rotProcess == true)
                time++;
            else
                break;
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        
        
        return time;
    }
}