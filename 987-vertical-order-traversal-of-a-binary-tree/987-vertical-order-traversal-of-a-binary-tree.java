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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer,TreeMap<Integer,List<Integer>>> map = new HashMap<>();
        
        int val[] = new int[2];
        val[0] =  10000;
        val[1] = -10000;
        
        vertical(root, 0, 0, map, val);
        
        int min = val[0];
        int max = val[1];
        
        List< List<Integer>> list = new ArrayList<>();
        
        for(int i = min;i<=max;i++)
        {
            TreeMap<Integer, List<Integer>> map2 = map.get(i);
            List<Integer> list1 = new ArrayList<>();
            
            for(int j : map2.keySet())
            {
                List<Integer> arr = map2.get(j);
                
                Collections.sort(arr);
                
                for(int k :arr)
                list1.add(k);
            }
            
            list.add(list1); 
        }
        return list;
    }
    public void vertical(TreeNode root, int row, int level , HashMap<Integer,TreeMap<Integer ,List<Integer>>> map,int val[])
    {
        if(root == null)
            return;
        
        TreeMap<Integer, List<Integer>> map2 = map.getOrDefault(level, new TreeMap<>());
         List<Integer> arr = map2.getOrDefault( row, new ArrayList<>());
        
        arr.add(root.val);
        map2.put(row, arr);
        map.put(level, map2);
        
        val[0] = Math.min(val[0], level);
        val[1] = Math.max(val[1], level);
        
        vertical(root.left, row+1, level-1, map, val);
        vertical(root.right, row+1, level+1, map, val);
        
        return;
}
}