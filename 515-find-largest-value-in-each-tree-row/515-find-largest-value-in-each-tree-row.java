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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return ans;
        }
        queue.add(root);
        
        while(!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = queue.size(); // It represents the number of nodes present at any Level.
            
            while(size > 0){
                TreeNode currentNode = queue.remove();
                if(currentNode.val > max){
                    max = currentNode.val;
                }
                
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
                size--;
            }
            ans.add(max);
        }
        return ans;
    }
}