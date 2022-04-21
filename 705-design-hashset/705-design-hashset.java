class Node{
    int val;
    Node prev = null;
    Node next = null;
    Node(){
    }
    Node(int val){
        this.val = val;
    }
}
class MyHashSet {

    Node head;
    public MyHashSet() {
        head = null;
    }
    
    public void add(int key) {
        if(contains(key)){
            return;
        }
        else{
            addAtTail(key);
        }
        
    }
    
    public void remove(int key) {
        if(contains(key)){
            int index = 0;
            Node current = head;
            while(current.val != key){
                index++;
                current = current.next;
            }
            deleteAtIndex(index);
            return;
        }
    }
    
    public boolean contains(int key) {
        Node current = head;
        while(current != null){
            if(current.val == key){
                return true;
            }
            current = current.next;
        }
        
        return false;
        
    }
    
    public void deleteAtIndex(int index) {
        if(head == null){
            return ;
        }
        if(index == 0){
            deleteNodeFromStart();
            return;
        }
        
        Node current = head;
        for(int i=0; i < index; i++){
            current = current.next;
            if(current == null){
                return;
            }
        }
        
        if(current.next == null){
            deleteNodeFromEnd();
            return;
        }
        
        Node prevNode = current.prev;
        Node nextNode = current.next;
        
        nextNode.prev = prevNode;
        prevNode.next = nextNode;
        
        current.prev = null;
        current.next = null;
        return;
        
    }
    
    public void addAtTail(int val) {
        
        if(head == null){
            Node newNode = new Node(val);
            head = newNode;
            return;
        }
        
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        
        Node newNode = new Node(val);
        newNode.prev = current;
        current.next = newNode;
        
        return;
        
    }
    
    public void deleteNodeFromStart(){
        if(head == null || head.next == null){
            head = null;
            return;
        }
        
        Node current = head;
        current.next.prev = null;
        head = current.next;
        
        current.next = null;
        return ;
    }
    
    public void deleteNodeFromEnd(){
        if(head == null || head.next == null){
            head = null;
            return;
        }
        
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        
        current.prev.next = null;
        current.prev = null;
        return;
        
    }
    
    
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */