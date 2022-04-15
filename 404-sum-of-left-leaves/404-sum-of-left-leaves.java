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
        int ans[] = new int[1];
        
        calculateSumOfLeftLeaves(root, ans, false);
        
        return ans[0];
    }
    
    private void calculateSumOfLeftLeaves(TreeNode root, int[] ans, boolean isLeft){
        
        if(root == null){
            return;
        }
        
        if(root.right == null && root.left == null && isLeft == true){
            ans[0] += root.val;
        } 
        
        calculateSumOfLeftLeaves(root.left, ans, true);
        calculateSumOfLeftLeaves(root.right, ans, false);
        
        
    }
    
}