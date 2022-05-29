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
    public boolean isValidBST(TreeNode root) {
        
        List<Integer> traversal = new ArrayList<>();
        inorderTraversal(root, traversal);
        
        for(int i = 1; i < traversal.size(); i++){
            if(traversal.get(i) <= traversal.get(i - 1)){
                return false;
            }
        }
    
        return true;
        
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> traversal){
        
        if(root == null){
            return;
        }
        
        inorderTraversal(root.left, traversal);
        traversal.add(root.val);
        inorderTraversal(root.right, traversal);
        
    }
  
    
}