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
        if(node == null)
            return node;
        
        HashMap<Integer,Node> graph = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(node);
        
        while(q.size() > 0){
            
            Node cn = q.poll();
            
            if(visited.contains(cn.val))
                continue;
            
            if(!graph.containsKey(cn.val))
            {
                Node newNode = new Node(cn.val);
                graph.put(cn.val , newNode);
            }
            
            visited.add(cn.val);

            List<Node> list = new ArrayList<>();
            
            for(Node current : cn.neighbors){
                if(!graph.containsKey(current.val))
                {
                    Node newNode = new Node(current.val);
                    graph.put(newNode.val , newNode);
                     q.add(current);
                }
                
                list.add(graph.get(current.val));
                
            }
         
            Node newNode = graph.get(cn.val);
            newNode.neighbors = list;
            
        }
  
        return graph.get(1);
        //return ans;
    }
}