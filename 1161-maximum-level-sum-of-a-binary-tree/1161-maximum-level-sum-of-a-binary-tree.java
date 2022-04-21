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
    public int maxLevelSum(TreeNode root) {
        int ans = 1;
        int level = 1;
        int max = Integer.MIN_VALUE;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int sum = 0;
            int size = queue.size(); // It represents the number of nodes present at any Level.
            
            while(size > 0){
                TreeNode currentNode = queue.remove();
                sum += currentNode.val;
                
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
                size--;
            }
            
            if(sum > max){
                ans = level;
                max = sum;
            }
            level++;
        }
        return ans;
    }
}