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
    public int sumNumbers(TreeNode root) {
        int sum = root.val;
        return func(root,sum);
    }
    public int func(TreeNode root,int sum)
    {
        if(root.left==null && root.right==null)
            return sum;
        int left = 0;
        int right = 0;
        if(root.left!=null)
            left = func(root.left,sum*10+root.left.val);
        if(root.right!=null)
            right = func(root.right,sum*10+root.right.val);
        return left + right;
    }
}