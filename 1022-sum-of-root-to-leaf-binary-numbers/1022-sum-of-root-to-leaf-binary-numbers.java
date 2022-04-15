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
    public int sumRootToLeaf(TreeNode root) {
        return sumOfRootToLeaf(root, "");
    }
    
    private int sumOfRootToLeaf(TreeNode root, String currentAns){
        
        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right == null){
            currentAns += root.val;
            return Integer.parseInt(currentAns, 2);
        }
        
        return sumOfRootToLeaf(root.left, currentAns + root.val) + sumOfRootToLeaf(root.right, currentAns + root.val);
        
    }
    
}