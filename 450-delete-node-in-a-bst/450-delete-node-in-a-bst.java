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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
            return root;
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
            return root;
        }
        else{
            if(root.left == null && root.right == null){
                root = null;
                return root;
            }
            if(root.left != null && root.right == null){
                root = root.left;
                return root;
            }
            else if(root.right != null && root.left == null){
                root = root.right;
                return root;
            }
            else{
                TreeNode tempNode = findLeftMostNode(root.right);
                
                int temp = root.val;
                root.val = tempNode.val;
                tempNode.val = temp;
                
                root.right = deleteNode(root.right, tempNode.val);
                return root;
            }
        }
        
    }
    
    private TreeNode findLeftMostNode(TreeNode currentNode){
        while(currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode;
    }
}