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
        HashMap<TreeNode, TreeNode> childParent = new HashMap<>();
        
        childAndParent(root, childParent, null);
        
        List<Integer> answer = new ArrayList<>();
        nodesAtDistanceK(target, k, new HashSet<>(), answer, childParent);
        return answer;
    }
    
    private void childAndParent(TreeNode root, HashMap<TreeNode, TreeNode> childParent, TreeNode parent){
        if(root == null){
            return;
        }
        
        childParent.put(root, parent);
        
        childAndParent(root.left, childParent, root);
        childAndParent(root.right, childParent, root);
        
    }
    
    private void nodesAtDistanceK(TreeNode root, int k, HashSet<TreeNode> set, List<Integer> answer, HashMap<TreeNode, TreeNode> childParent){
        
        if(root == null || set.contains(root)){
            return;
        }
        
        if(k == 0){
            answer.add(root.val);
            return;
        }
        
        set.add(root);
        nodesAtDistanceK(root.left, k - 1, set, answer, childParent);
        nodesAtDistanceK(root.right, k - 1, set, answer, childParent);
        nodesAtDistanceK(childParent.get(root), k - 1, set, answer, childParent);
        
    }
}
