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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        while(root!=null && (root.val<low || root.val>high ))
              {
            if(root.val<low)
            {
           // System.out.print("hey");
            TreeNode temp = root;
            root = root.right;
            temp.right=null;
            temp.left=null;
            temp = null;
            }
        else if(root.val>high)
        {
            TreeNode temp = root;
            root = root.left;
            temp.right=null;
            temp.left=null;
             temp = null;
        }
              }
       // System.out.println(root.val);
         trimbst(root,low,high,null);
        return root;
    }
    private void trimbst(TreeNode root, int low, int high,TreeNode parent)
    {
        if(root==null)
            return;
        if(root.val<low)
        {
            System.out.print("hey");
            TreeNode temp = root;
            root = root.right;
            if(parent!=null && temp==parent.left)
                parent.left = root;
            else if(parent!=null && temp == parent.right)
                parent.right = root;
            temp.right=null;
            temp.left=null;
            temp = null;
             trimbst(root,low,high,parent);
            return;
        }
        else if(root.val>high)
        {
            TreeNode temp = root;
            root = root.left;
            if(parent!=null && temp==parent.left)
                parent.left = root;
            else if(parent!=null && temp == parent.right)
                parent.right = root;
            temp.right=null;
            temp.left=null;
             temp = null;
            trimbst(root,low,high,parent);
            return;
           
        }
       trimbst(root.left,low,high,root);
        trimbst(root.right,low,high,root);
            return;
    }
}