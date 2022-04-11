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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        
        if(root == null){
            return answer;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            List<Integer> currentAns = new ArrayList<>();
            
            while(size > 0){
                TreeNode currentNode = queue.remove();
                currentAns.add(currentNode.val);
                
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
                size--;
            }
            
            answer.add(currentAns);
            
        }
        return answer;
    }
}