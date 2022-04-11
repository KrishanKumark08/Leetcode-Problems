/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        int depth = 0;
        
        if(root == null){
            return depth;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int size = queue.size(); // It represents the number of nodes present at any Level.
            
            while(size > 0){
                Node currentNode = queue.remove();
                
                for(Node child:currentNode.children){
                    queue.add(child);
                }
                size--;
            }
            
            depth++;
            
        }
        return depth;
    }
}