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
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;
        if(root.right==null&&root.left==null)
            return root;
        invert(root);
        return root;
    }
    public void invert(TreeNode root)
    {
        if(root==null)
            return ;
        if(root.right==null&&root.left==null)
            return ;
        if(root.right==null)
        {
            root.right=root.left;
            root.left=null;
             invertTree(root.right);
            return;
        }
        if(root.left==null)
        {
             root.left=root.right;
             root.right=null;
              invertTree(root.left);
            return;
        }
        
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
         invertTree(root.left);
       invertTree(root.right);
        return ;
    }
}