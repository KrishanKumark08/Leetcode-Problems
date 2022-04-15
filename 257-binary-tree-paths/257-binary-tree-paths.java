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
        List<String> answer = new ArrayList<>();
        if(root == null){
            return answer;
        }
        treePaths(root, answer, "");
        return answer;
    }
    
    private void treePaths(TreeNode root, List<String> answer, String currentAns){
        
        if(root.left == null && root.right == null){
            currentAns += root.val;
            answer.add(currentAns);
            return;
        }
        
        if(root.left != null){
            treePaths(root.left, answer, currentAns + root.val + "->");
        }
        
        if(root.right != null){
            treePaths(root.right, answer, currentAns + root.val + "->");
        }
        
    }   
}