/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummyNode = new Node(-10001);
        Node newHead = dummyNode;
            
        HashMap<Node, Node> memo = new HashMap<>();
        
        Node current = head;
        while(current!= null){
            Node newNode = new Node(current.val);
            newHead.next = newNode;
            newHead = newNode;
            memo.put(current, newNode);
            current = current.next;
        }
        
        current = head;
        newHead = dummyNode.next;
        while(current != null){
            newHead.random = memo.get(current.random);
            current = current.next;
            newHead = newHead.next;
        }
        
        return dummyNode.next;
        
    }
}