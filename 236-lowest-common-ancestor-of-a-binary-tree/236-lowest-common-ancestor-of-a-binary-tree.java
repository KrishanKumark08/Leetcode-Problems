/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        
        TreeNode leftCall = lowestCommonAncestor(root.left, p, q);
        TreeNode rightCall = lowestCommonAncestor(root.right, p, q);
        
        if(leftCall == null && rightCall == null){
            return null;
        }
        else if(leftCall != null && rightCall == null){
            return leftCall;
        }
        else if(rightCall != null && leftCall == null){
            return rightCall;
        }
        
        return root;
        
    }
}