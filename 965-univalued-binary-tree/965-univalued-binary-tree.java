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
    public boolean isUnivalTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        
        HashSet<Integer> set = new HashSet<>();
        
        queue.add(root);
        
        while(queue.size() > 0){
            int currentSize = queue.size();
            
            while(currentSize > 0){
                TreeNode currentNode = queue.remove();
                
                set.add(currentNode.val);
                
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
                currentSize--;
            }
            
            if(set.size() > 1){
                return false;
            }
            
        }
        return set.size() == 1;
    }
}