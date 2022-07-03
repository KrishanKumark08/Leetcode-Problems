/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        
        HashMap<TreeNode, TreeNode> parents = new HashMap<>();
        calculateChildParent(root, parents, null);
        nodesAtDistanceK(target, k, ans, parents, new HashSet<TreeNode>());
        
        return ans;
        
    }
    
    private void calculateChildParent(TreeNode root, HashMap<TreeNode, TreeNode> parents, TreeNode parent){
        if(root == null){
            return;
        }
        
        parents.put(root, parent);
        calculateChildParent(root.left, parents, root);
        calculateChildParent(root.right, parents, root);
        return;
    }
    
    private void nodesAtDistanceK(TreeNode root, int k, List<Integer> ans, HashMap<TreeNode, TreeNode> parents, HashSet<TreeNode> visited){
        if(root == null || visited.contains(root)){
            return;
        }
        
        if(k == 0){
            ans.add(root.val);
            return;
        }
        
        visited.add(root);
        nodesAtDistanceK(root.left, k - 1, ans, parents, visited);
        nodesAtDistanceK(root.right, k - 1, ans, parents, visited);
        nodesAtDistanceK(parents.get(root), k - 1, ans, parents, visited);
        visited.remove(root);
        return;
        
    }
    
}