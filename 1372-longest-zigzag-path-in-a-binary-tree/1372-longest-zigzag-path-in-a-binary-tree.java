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
    
    int ans = 0;
    
    public int longestZigZag(TreeNode root) {
        longestZigZagPath(root.left, 1, true);
        longestZigZagPath(root.right, 1, false);
        
        return ans;
        
    }
    
    private void longestZigZagPath(TreeNode root, int level, boolean isPrevMoveLeft){
        if(root == null){
            return;
        }
        
        ans = Math.max(ans, level);
        
        if(isPrevMoveLeft == true){
            longestZigZagPath(root.right, level + 1, false);
            longestZigZagPath(root.left, 1, true);
        }
        else{
            longestZigZagPath(root.left, level + 1, true);
            longestZigZagPath(root.right, 1, false);
        }
        
        
    }
    
}