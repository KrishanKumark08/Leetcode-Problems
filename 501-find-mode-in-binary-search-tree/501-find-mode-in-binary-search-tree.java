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
    public int[] findMode(TreeNode root) {
        
        Map<Integer, Integer> traversal = new HashMap<>();
        inorderTraversal(root, traversal);
        
        List<Integer> ans = new ArrayList<>();
        
        int max = Integer.MIN_VALUE;
        for(int key:traversal.keySet()){
            if(traversal.get(key) > max){
                ans = new ArrayList<>();
                ans.add(key);
                max = traversal.get(key);
            }
            else if(traversal.get(key) == max){
                ans.add(key);
            }
        }
        
        int arr[] = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            arr[i] = ans.get(i);
        }
        
        return arr;
        
    }
    
    private void inorderTraversal(TreeNode root, Map<Integer, Integer> traversal){
        
        if(root == null){
            return;
        }
        
        inorderTraversal(root.left, traversal);
        traversal.put(root.val, traversal.getOrDefault(root.val, 0) + 1);
        inorderTraversal(root.right, traversal);
        
    }
    
}