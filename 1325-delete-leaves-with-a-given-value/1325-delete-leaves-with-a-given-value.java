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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null)
            return root;
        return removal(root,target);
    }
    
    public TreeNode removal(TreeNode root,int target)
    {
        if(root==null)
            return root;
        
        root.left = removal(root.left,target);
         root.right = removal(root.right,target);
        
        if(root.left==null && root.right==null)
        {
            if(root.val == target)
                return null;
            
            return root;
        }
        return root;
    }
}