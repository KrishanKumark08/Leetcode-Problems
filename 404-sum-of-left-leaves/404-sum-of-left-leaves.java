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
    public int sumOfLeftLeaves(TreeNode root) {
        return sumleftleaves(root,false);
    }
    private int sumleftleaves(TreeNode root,boolean flag)
    {
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null&&flag==true)
        {   
            
            return root.val;
        }
        return sumleftleaves(root.left,true)+sumleftleaves(root.right,false);
    }
}