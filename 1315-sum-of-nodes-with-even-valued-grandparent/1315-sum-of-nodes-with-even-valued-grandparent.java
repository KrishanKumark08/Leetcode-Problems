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
    public int sumEvenGrandparent(TreeNode root) {
        HashMap<TreeNode,TreeNode> parentmap = new HashMap<>();
        HashMap<TreeNode,TreeNode> grandparentmap = new HashMap<>();
        int sum =0;
        
        populateparent(root, null, parentmap);
        populategrandparent( parentmap, grandparentmap);
        
        for(TreeNode j:grandparentmap.keySet())
        {
            TreeNode i = grandparentmap.get(j);
            if(i != null && i.val%2 ==0)
            {
                System.out.println(j.val);
                 sum = sum + j.val;
            }
        }
        return sum;
    }
    public void populateparent(TreeNode root,TreeNode parent,HashMap<TreeNode,TreeNode> parentmap)
    {
        if(root == null)
        return;
        
        parentmap.put(root, parent);
        
        populateparent(root.left, root, parentmap);
        populateparent(root.right, root, parentmap);
        
        return;
    }
   public void populategrandparent(HashMap<TreeNode,TreeNode> parentmap,HashMap<TreeNode,TreeNode> grandparentmap)
    {
        for(TreeNode j : parentmap.keySet())
        {
            if(parentmap.get(j)!=null)
            grandparentmap.put(j,parentmap.get(parentmap.get(j)));
            else
            grandparentmap.put(j,null);
        }
       return;
    }
}