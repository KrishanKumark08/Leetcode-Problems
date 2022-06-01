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
    int index = 0;
    List<Integer> list = new ArrayList<>();
    
    public BSTIterator(TreeNode root) {
        inorder(root, list);
    }
    
    private void inorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        
    }
    
    public int next() {
        int ele = list.get(index);
        index++;
        return ele;
    }
    
    public boolean hasNext() {
        if(index < list.size()){
            return true;
        }
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */