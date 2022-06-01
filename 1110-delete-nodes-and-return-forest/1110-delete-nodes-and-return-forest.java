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
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        HashMap<Integer, TreeNode> nodeMap = new HashMap<>();
        populateMap(root, parentMap, null, nodeMap);
        
        List<TreeNode> ans = new ArrayList<>();
        ans.add(root);
        
        HashSet<TreeNode> set = new HashSet<>();
        for(int i : to_delete){
            set.add(nodeMap.get(i));
        }
        
        for(int i:to_delete){
            TreeNode currNode = nodeMap.get(i);
            if(currNode == root){
                ans.remove(root);
                if(currNode.left != null){
                if(!set.contains(currNode.left))
                    ans.add(currNode.left);
            }
            
            if(currNode.right != null){
                if(!set.contains(currNode.right))
                    ans.add(currNode.right);
            }
                continue;
            }
            if(currNode.left != null){
                if(!set.contains(currNode.left))
                    ans.add(currNode.left);
            }
            
            if(currNode.right != null){
                if(!set.contains(currNode.right))
                    ans.add(currNode.right);
            }
            
            if(currNode != root){
                    TreeNode parent = parentMap.get(currNode);
                
                if(parent.left == currNode){
                parent.left = null;
            }
            else{
                parent.right = null;
            }  
            } 
        }
        return ans;
    }
    
    private void populateMap(TreeNode root, HashMap<TreeNode, TreeNode> memo, TreeNode parent, HashMap<Integer, TreeNode> nodeMap){
        if(root == null){
            return;
        }
        memo.put(root, parent);
        nodeMap.put(root.val, root);
        populateMap(root.left, memo, root, nodeMap);
        populateMap(root.right, memo, root, nodeMap);
    }
    
}