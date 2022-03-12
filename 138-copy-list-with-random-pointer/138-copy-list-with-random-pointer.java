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
        if(head==null)
            return null;
        Node c=head;
        Node n=new Node(c.val);
        Node v=n;
        HashMap<Node,Node> map=new HashMap<>();
        map.put(c,v);
        while(c.next!=null)
        {
            c=c.next;
            Node d=new Node(c.val);
            v.next=d;
            v=v.next;
            map.put(c,v);
        }
        // for(Node i:map.keySet())
        // {
        //     System.out.println(i.val);
        // }
        // for(Node i:map.values())
        // {
        //     System.out.println(i.val);
        // }
        c=head;
        v=n;
        while(c!=null)
        {
            // if(c.random==null)
            //     v.random=null;
            // else
                v.random=map.get(c.random);
            c=c.next;
            v=v.next;
        }
        return n;
    }
}