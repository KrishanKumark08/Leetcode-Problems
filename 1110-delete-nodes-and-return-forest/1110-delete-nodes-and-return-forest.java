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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
         HashMap<Integer , TreeNode> map = new HashMap<>();
        HashMap<Integer , TreeNode> map2 = new HashMap<>();
        for(int i : to_delete)
            map.put(i,null);
        
         fillmap( root, null,map,map2);
        List<TreeNode> ans= new ArrayList<>();
        int o =-100000;
        if(map.containsKey(root.val))
        {
            if(root.left!=null && !map.containsKey(root.left.val))
               ans.add(root.left);
            if(root.right!=null && !map.containsKey(root.right.val))
               ans.add(root.right);
            o = root.val;
            root=null;
        }
        else
        ans.add(root);
        for(int i :to_delete)
        {
            if(i == o)
                continue;
            TreeNode r = map.get(i);
            if(r!=null)
            {
            TreeNode f =null;
            if(r.left!=null && r.left.val == i)
            {
                f = r.left;
                r.left = null;
            }
            else
            {
                f = r.right;
                r.right=null;
            }
            r = f;
            }
            else
                r = map2.get(i);
        
            if(r.left!=null && !map.containsKey(r.left.val))
                ans.add(r.left);
            if(r.right!=null && !map.containsKey(r.right.val))
                ans.add(r.right);
            
            // r.left = null;
            // r.right = null;
            // r = null;
        }
        return ans;
    }
    public void fillmap(TreeNode root,TreeNode parent, HashMap<Integer , TreeNode> map, HashMap<Integer , TreeNode> map2)
    {
        if(root == null)
            return;
        if(map.containsKey(root.val))
        {
            map.put(root.val,parent);
            map2.put(root.val,root);
        }
        
        fillmap( root.left ,root, map,map2);
        fillmap(root.right ,root, map,map2);
        
        return;
    }
}