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
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        long min[] = new long[1];
    min[0]=-99999999999l;
       return isvalid(root,min);
    }
    public boolean isvalid(TreeNode root,long[] min)
    {
        if(root==null)
            return true;
        
         boolean l = isvalid(root.left,min);
         if(root.val<=min[0] )
         return false;
        
        min[0] = root.val;
        boolean r = isvalid(root.right,min);
        
        return l && r;
    }
}