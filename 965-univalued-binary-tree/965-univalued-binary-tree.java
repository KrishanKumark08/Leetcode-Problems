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
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalued(root, root.val);
    }
    
    private boolean isUnivalued(TreeNode root, int value){
        if(root == null){
            return true;
        }
        
        return root.val == value && isUnivalued(root.left, value) && isUnivalued(root.right, value);
        
    }
    
}