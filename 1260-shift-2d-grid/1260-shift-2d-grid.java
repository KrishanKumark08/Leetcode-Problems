class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int r=grid.length;
        int c=grid[0].length;
        int oned[] = new int [r*c];
       
        int temp[][] = new int [r][c];
        
        for (int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                int newIndex = (i*c+j+ k) % oned.length;
                int newr = newIndex / c;
                int newc = newIndex % c;
                temp[newr][newc] = grid[i][j];
            }
        }
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = 0; i < r; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j < c; j++) {
                list.add(temp[i][j]);
            }
            result.add(list);
        }

        return result;
    }
}