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
    public int deepestLeavesSum(TreeNode root) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        nodesSumAtAllLevels(root, 1, memo);
        
        return memo.get(memo.size());
        
    }
    
    private void nodesSumAtAllLevels(TreeNode root, int level, HashMap<Integer, Integer> memo){
        
        if(root == null){
            return;
        }
        
        memo.put(level, memo.getOrDefault(level, 0) + root.val);
        
        nodesSumAtAllLevels(root.left, level + 1, memo);
        nodesSumAtAllLevels(root.right, level + 1, memo);
        
        
    }
    
}