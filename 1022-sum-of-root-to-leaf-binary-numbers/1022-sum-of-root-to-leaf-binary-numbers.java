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
        if(root.left == null && root.right == null){
            return Integer.parseInt(currentAns + root.val, 2);
        }
        
        int leftSum = 0;
        int rightSum = 0;
        if(root.left != null){
            leftSum = sumOfRootToLeaf(root.left, currentAns + root.val);
        }
        
        if(root.right != null){
            rightSum = sumOfRootToLeaf(root.right, currentAns + root.val);
        }
        
        return leftSum + rightSum;
    }
}