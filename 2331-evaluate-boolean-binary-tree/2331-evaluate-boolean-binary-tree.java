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
    public boolean evaluateTree(TreeNode root) {
        return evaluate(root);
    }
    
    private boolean evaluate(TreeNode root){
        if(root.right == null){
            return root.val == 1;
        }
        
        if(root.val == 2){
            return evaluate(root.left) || evaluate(root.right);
        }
        
        return evaluate(root.left) && evaluate(root.right);
        
    }
    
}