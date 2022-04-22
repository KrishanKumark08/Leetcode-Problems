class Node{
    int val;
    int data;
    Node next=null;
    Node prev=null;
    Node()
    {}
    Node(int v,int d)
    {
        val=v;
        data=d;
    }
}
class MyHashMap {
    Node head=new Node();
    public MyHashMap() {
        head=null;
    }
     public boolean contains(int key) {
         if(head==null)
            return false;
        Node p=head;
        int index=0;
        while(p!=null&&p.val!=key)
        {
            index++;
            p=p.next;
        }
        if(p==null)return false;
        return true;
    }
    public void put(int key, int value) {
        boolean a= contains(key);
        if(a==true){
            Node p=head;
        while(p!=null&&p.val!=key)
        {
            //index++;
            p=p.next;
        }
       // if(p==null)return -1;
        p.data=value;
            return;
        }
        Node d=new Node(key,value);
        
        if(head==null)head=d;
        else
        {
            head.prev=d;
            d.next=head;
            head=d;
        }
        return;
    }
    
    public int get(int key) {
        if(head==null)
            return -1;
        Node p=head;
        while(p!=null&&p.val!=key)
        {
            //index++;
            p=p.next;
        }
        if(p==null)return -1;
        return p.data;
    }
    
    public void remove(int key) {
        if(head==null)
            return;
        Node p=head;
        int index=0;
        while(p!=null&&p.val!=key)
        {
            index++;
            p=p.next;
        }
        if(p==null)return;
        p=head;
        if(index==0)
        {
            head=head.next;
            p=null;
            if(head!=null)head.prev=null;
            return;
        }
            while(index>1)
            {
                index--;
                p=p.next;
                if(p.next==null)
                    return ;
            }
        if(p.next==null)return;
        Node q=p.next;
        p.next=p.next.next;
        q.next=null;
        q.prev=null;
        q=null;
        return ;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */