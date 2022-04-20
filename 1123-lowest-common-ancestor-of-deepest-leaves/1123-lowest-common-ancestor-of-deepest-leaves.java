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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        List<TreeNode> deepestLeaves = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int size = queue.size(); // It represents the number of nodes present at any Level.
            List<TreeNode> currentAns = new ArrayList<>();
            
            while(size > 0){
                TreeNode currentNode = queue.remove();
                currentAns.add(currentNode);
                
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
                size--;
            }
            deepestLeaves = currentAns;
        }
        
        
        if(deepestLeaves.size() == 1){
            return deepestLeaves.get(0);
        }
        
        for(int i = 1; i < deepestLeaves.size(); i++){
            TreeNode ans = lowestCommonAncestor(root, deepestLeaves.get(i - 1), deepestLeaves.get(i));
            deepestLeaves.set(i, ans);
        }
        
        return deepestLeaves.get(deepestLeaves.size() - 1);
        
    }
    
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        
        TreeNode leftAns = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAns = lowestCommonAncestor(root.right, p, q);
        
        if(leftAns != null && rightAns != null){
            return root;
        }
        
        if(leftAns != null){
            return leftAns;
        }
        
        if(rightAns != null){
            return rightAns;
        }
        
        return null;
        
    }
    
}