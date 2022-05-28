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
class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        pushall(root);
    }
    
    public int next() {
        TreeNode r = stack.pop();
        pushall(r.right);
        return r.val;
    }
    
    public boolean hasNext() {
        if(stack.size()>0)
            return true;
        return false;
    }
    public void pushall(TreeNode root)
    {
        while(root!=null)
        {
            stack.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */