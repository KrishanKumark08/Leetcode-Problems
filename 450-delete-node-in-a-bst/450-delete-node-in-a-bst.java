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
        if(root==null)
            return root;
        
        if(root.val<key)
            root.right = deleteNode(root.right,key);
        
        else if(root.val>key)
            root.left = deleteNode(root.left,key);
        
        else
        {
           if(root.left==null && root.right==null)
           {
               root = null;
               return root;
           }
            if(root.left==null)
            {
                root = root.right;
                return root;
            }
            
           if(root.right==null)
            {
              root = root.left;
                return root;
            }
            
            if(root.left!=null && root.right!=null)
            {
                TreeNode temp = root.right;
                while(temp.left!=null)
                {
                    temp = temp.left;
                }
                int h = root.val;
                root.val=temp.val;
                temp.val = h;
                root.right = deleteNode(root.right,temp.val);
                return root;
            }
        }
        return root;
    }
}