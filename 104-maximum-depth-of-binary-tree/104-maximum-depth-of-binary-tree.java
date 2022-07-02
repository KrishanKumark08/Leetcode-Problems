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
    public int maxDepth(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root != null){
            queue.add(root);
        }
        
        while(!queue.isEmpty()){
            int currentSize = queue.size();
            
            while(currentSize > 0){
                TreeNode currentNode = queue.poll();
                
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
                currentSize--;
            }
            depth++;
        }
        return depth;
    }
}