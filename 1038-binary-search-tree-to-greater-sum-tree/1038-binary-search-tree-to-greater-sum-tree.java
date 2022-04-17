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
    public TreeNode bstToGst(TreeNode root) {
       List<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        int sum = 0;
        for(int i : list){
            sum += i;
        }
        
        HashMap<Integer, Integer> memo = new HashMap<>();
        for(int i : list){
            sum -= i;
            memo.put(i, sum);
        }
        
        conversion(root, memo);
            
        return root;
        
    }
    
    private void inorder(TreeNode root, List<Integer> list){
        
       if(root == null){
           return;
       }
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        
    }
    
    private void conversion(TreeNode root, HashMap<Integer, Integer> memo){
        if(root == null){
            return;
        }
        
        root.val = root.val + memo.get(root.val);
        
        conversion(root.left, memo);
        conversion(root.right, memo);
        
    }
    
    
}