/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> memo = new TreeMap<>();
        
        populateMapWithColumns(root, 0, 0, memo);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int key : memo.keySet()){
            TreeMap<Integer, List<Integer>> rowMap = memo.get(key);
            List<Integer> list1 = new ArrayList<>();
            for(int row : rowMap.keySet()){
                List<Integer> list2 = rowMap.get(row);
                Collections.sort(list2);
                for(int ele : list2){
                    list1.add(ele);
                }
            }
            
            ans.add(list1);
        }
        
        return ans;
        
    }
    
    private void populateMapWithColumns(TreeNode root, int col, int row, TreeMap<Integer, TreeMap<Integer, List<Integer>>> memo){
        
        if(root == null){
            return;
        }
        
        TreeMap<Integer, List<Integer>> rowMap = memo.getOrDefault(col, new TreeMap<>());
        List<Integer> rowList = rowMap.getOrDefault(row, new ArrayList<>());
        
        rowList.add(root.val);
        rowMap.put(row, rowList);
        memo.put(col, rowMap);
        
        populateMapWithColumns(root.left, col - 1, row + 1, memo);
        populateMapWithColumns(root.right, col + 1, row + 1, memo);
        
    }
    
}