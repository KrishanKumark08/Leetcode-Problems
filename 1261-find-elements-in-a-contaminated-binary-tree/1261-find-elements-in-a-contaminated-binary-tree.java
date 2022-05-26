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
class FindElements {
    TreeNode root1;
    public FindElements(TreeNode root) {
        root1 = root;
        root1.val = 0;
        recoverTree(root1);
    }
    
    public void recoverTree(TreeNode root){
        if(root == null){
            return;
        }
        
        if(root.left != null){
            root.left.val = 2*root.val + 1;
            recoverTree(root.left);
        }
        
        if(root.right != null){
            root.right.val = 2*root.val + 2;
            recoverTree(root.right);
        }
        
    }
    
    public boolean find(int target) {
        
        return contains(root1, target);
        
    }
    
    private boolean contains(TreeNode root, int target){
        
        if(root == null){
            return false;
        }
        
        return root.val == target || contains(root.left, target) || contains(root.right, target);
            
    }
    
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */