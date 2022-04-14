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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        rightView(root, memo, 0);
        
        for(int key:memo.keySet()){
            answer.add(memo.get(key));
        }
        
        return answer;
    }
    
    private void rightView(TreeNode root, HashMap<Integer, Integer> memo, int level){
        
        if(root == null){
            return;
        }
        
        memo.put(level, root.val);
        
        rightView(root.left, memo, level + 1);
        rightView(root.right, memo, level + 1);
        
    }
    
}