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
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null){
            return true;
        }
        
        return symmetric(root.left, root.right);
        
    }
    
    private boolean symmetric(TreeNode r1, TreeNode r2){
        
        if(r1 == null){
            if(r2 == null){
                return true;
            }
            else
                return false;
        }
        
        if(r2 == null){
            if(r1 == null){
                return true;
            }
            else
                return false;
        }
        
        return r1.val == r2.val && symmetric(r1.left, r2.right) && symmetric(r1.right, r2.left);
    }
    
}