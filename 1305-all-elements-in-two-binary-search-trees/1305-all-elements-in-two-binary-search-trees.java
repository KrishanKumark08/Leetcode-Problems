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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> answer = new ArrayList<>();
        
        inorder(root1, answer);
        inorder(root2, answer);
        Collections.sort(answer);
        return answer;
        
    }
    
    private void inorder(TreeNode root, List<Integer> answer){
        
        if(root == null){
            return;
        }
        
        inorder(root.left, answer);
        answer.add(root.val);
        inorder(root.right, answer);
        
        return;
        
    }
}