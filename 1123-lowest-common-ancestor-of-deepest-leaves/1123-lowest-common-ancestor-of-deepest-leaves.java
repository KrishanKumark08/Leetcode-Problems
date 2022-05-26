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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int l = heightofbt(root);
        return lca(root,l);
    }
    public int heightofbt(TreeNode root)
    {
        if(root==null)
            return 0;
        return 1 + Math.max(heightofbt(root.left) , heightofbt(root.right));
    }
    public TreeNode lca(TreeNode root, int l)
    {
        if(root==null)
            return null;
        if(root.right == null && root.left == null)
        {
            if(l==1)
            {
              
                return root;
            } 
            return null;
        }
        
        TreeNode right = lca(root.right,l-1);
        TreeNode left = lca(root.left,l-1);
        if(left != null && right != null  ) 
            return root;
        
         if(right != null ) 
            return right;
        
        if(left != null ) 
            return left;
        
        return null;
    }
}