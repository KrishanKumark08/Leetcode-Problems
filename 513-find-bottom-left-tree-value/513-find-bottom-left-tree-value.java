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
    public int findBottomLeftValue(TreeNode root) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        leftNodeAtEveryLevel(root, 1, memo);
        
        return memo.get(memo.size());
        
    }
    
    private void leftNodeAtEveryLevel(TreeNode root, int level, HashMap<Integer, Integer> memo){
        
        if(root == null){
            return;
        }
        
        if(!memo.containsKey(level))
        memo.put(level, root.val);
        
        leftNodeAtEveryLevel(root.left, level + 1, memo);
        leftNodeAtEveryLevel(root.right, level + 1, memo);
        
        
    }
}