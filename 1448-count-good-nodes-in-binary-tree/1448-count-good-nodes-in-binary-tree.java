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
        return countOfGoodNodes(root, -100000);
    }
    
    private int countOfGoodNodes(TreeNode root, int prevMax){
        if(root == null){
            return 0;
        }
        
        int ans = 0;
        if(root.val >= prevMax)
            ans = 1;
        
        return ans + countOfGoodNodes(root.left, Math.max(root.val, prevMax)) + countOfGoodNodes(root.right, Math.max(root.val, prevMax));
        
    }
}