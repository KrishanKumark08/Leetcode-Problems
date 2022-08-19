/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        if(node == null){
            return node;
        }
        
        HashMap<Integer, Node> memo = new HashMap<>(); 
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        HashSet<Integer> visited = new HashSet<>();
        
        Node ans = new Node(-1);
        
        while(!queue.isEmpty()){
            Node currNode = queue.remove();
            
            if(visited.contains(currNode.val)){
                continue;
            }
            
            visited.add(currNode.val);
            Node newNode;
            if(memo.containsKey(currNode.val))
                newNode = memo.get(currNode.val);
            else
            {
                newNode = new Node(currNode.val);
                memo.put(currNode.val, newNode);
            }
                
            
            if(ans.val == -1){
                ans = newNode;
            }
            
            //System.out.println("Hello");
            
            List<Node> newNeighbors = new ArrayList<>();
            for(Node neigh:currNode.neighbors){
                if(memo.containsKey(neigh.val)){
                    newNeighbors.add(memo.get(neigh.val));
                }
                else{
                    Node temp = new Node(neigh.val);
                    newNeighbors.add(temp);
                    memo.put(temp.val, temp);   
                }
                if(!visited.contains(neigh.val))
                    queue.add(neigh);
            }
            newNode.neighbors = newNeighbors; 
            for(Node n:newNeighbors){
               // System.out.print(n.val + " ");
            }
            //System.out.println();
        }
        return ans;
    }
}