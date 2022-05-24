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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashSet<TreeNode> set = new HashSet<>();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashMap<TreeNode, Integer> rootMap = new HashMap<>();
        
        for(int i = 0; i < descriptions.length; i++){
            TreeNode parent;
            TreeNode child;
            if(!map.containsKey(descriptions[i][0])){
                parent = new TreeNode(descriptions[i][0]);
                 map.put(descriptions[i][0], parent);
            }
            else{
                parent = map.get(descriptions[i][0]);
               
            }
            
            if(!map.containsKey(descriptions[i][1])){
                child = new TreeNode(descriptions[i][1]);
                map.put(descriptions[i][1], child);
            }
            else{
                child = map.get(descriptions[i][1]);
                
            }
            
            //System.out.println(" descriptions[i][0]  = "+descriptions[i][0] +" descriptions[i][1] = "+descriptions[i][1]);
            
            rootMap.put(child, rootMap.getOrDefault(child, 0) - 2);
            rootMap.put(parent, rootMap.getOrDefault(parent, 0) + 1);
            set.remove(child);
            set.add(parent);
            
            if(descriptions[i][2] == 1){
                parent.left = child;
                //System.out.println(" descriptions[i][0]  = "+descriptions[i][0] +" descriptions[i][1] = "+descriptions[i][1]+" descriptions[i][2] = "+descriptions[i][2]);
            }
            else{
                parent.right = child;
                //System.out.println(" descriptions[i][0]  = "+descriptions[i][0] +" descriptions[i][1] = "+descriptions[i][1]+" descriptions[i][2] = "+descriptions[i][2]);
            }  
        }
        
        TreeNode root = null;
        
        // for(TreeNode node:set){
        //     root = node;
        //     System.out.println("Node : "+root.val);
        // }
        
        for(TreeNode node:rootMap.keySet()){
            if(rootMap.get(node) > 0){
                root = node;
                break;
            }
        }
        
        return root;
        
    }
}