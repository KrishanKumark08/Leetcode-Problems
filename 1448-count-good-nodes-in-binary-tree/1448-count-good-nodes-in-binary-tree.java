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
    public int goodNodes(TreeNode root) {
        if(root==null)
            return 0;
        
        return  goodnodes(root,root.val);
    }
    public int goodnodes(TreeNode root , int max)
    {
        if(root == null)
            return 0;
        
        int ans =0;
        if(root.val >= max)
            ans = ans +1;
        return ans + goodnodes(root.left,Math.max(root.val,max)) + goodnodes(root.right,Math.max(root.val,max));
    }
}