class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minPath(0, 0, triangle,new HashMap<String, Integer>());
    }
    public int minPath(int currentRow, int currentCol, List<List<Integer>> triangle, HashMap<String, Integer> memo){
        if(currentRow >= triangle.size() || currentRow >= triangle.get(currentRow).size()){
            return 0;
        }
        if(currentRow == triangle.size() - 1){
            return triangle.get(currentRow).get(currentCol);   
        }
        
        String currentKey = currentRow + "_" + currentCol;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int i = triangle.get(currentRow).get(currentCol) + minPath(currentRow + 1, currentCol, triangle, memo);
        
        int iPlusOne = triangle.get(currentRow).get(currentCol) + minPath(currentRow + 1, currentCol + 1, triangle, memo);
        
        memo.put(currentKey, Math.min(i, iPlusOne));
        return memo.get(currentKey);
        
    }
}