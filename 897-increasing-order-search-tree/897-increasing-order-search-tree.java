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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        inorderTraversal(root, traversal);
        
        TreeNode dummyNode =new TreeNode(-1);
        TreeNode  newRoot = dummyNode;
        
        for(int val:traversal){
            dummyNode.right = new TreeNode(val);
            dummyNode = dummyNode.right;
        }
        
        return newRoot.right;
        
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> traversal){
        
        if(root == null){
            return;
        }
        
        inorderTraversal(root.left, traversal);
        traversal.add(root.val);
        inorderTraversal(root.right, traversal);
        
        return;
        
    }
    
}