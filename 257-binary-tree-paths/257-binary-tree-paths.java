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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        allRootToLeafPaths(root, "", ans);
        return ans;
    }
    
    private void allRootToLeafPaths(TreeNode root, String currentAns, List<String> ans){
        if(root.left == null && root.right == null){
            ans.add(currentAns + root.val);
            return;
        }
        
        if(root.left != null){
            allRootToLeafPaths(root.left, currentAns + root.val + "->", ans);
        }
        
        if(root.right != null){
            allRootToLeafPaths(root.right, currentAns + root.val + "->", ans);
        }
        
    }
    
}