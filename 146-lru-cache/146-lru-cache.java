class DLLNode{
    int key;
    int value;
    DLLNode prev;
    DLLNode next;
    DLLNode(int key, int value){
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    int size;
    int capacity;
    DLLNode head;
    DLLNode tail;
    HashMap<Integer, DLLNode> memo = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);
        head.next = tail;
        head.prev = tail;
        tail.prev = head;
        tail.next = head;
    }
    
    public int get(int key) {
        if(!memo.containsKey(key)){
            return -1;
        }
        
        deleteNode(memo.get(key));
        addNodeAtTail(memo.get(key));
        
        return memo.get(key).value;
        
    }
    
    public void put(int key, int value) {
        if(memo.containsKey(key)){
            deleteNode(memo.get(key));
            memo.get(key).value = value;
            addNodeAtTail(memo.get(key));
            return;
        }
        
        if(size == capacity){
            deleteNodeFromFront();
        }
        
        DLLNode newNode = new DLLNode(key, value);
        size++;
        memo.put(key, newNode);
        addNodeAtTail(newNode);
        
    }
    
    private void deleteNodeFromFront(){
        DLLNode tempNode = head.next;
        head.next = head.next.next;
        tempNode.next.prev = head;
        tempNode.next = null;
        tempNode.prev = null;
        size--;
        memo.remove(tempNode.key);
    }
    
    private void deleteNode(DLLNode currentNode){
        DLLNode tempNode = currentNode.prev;
        currentNode.next.prev = tempNode;
        tempNode.next = currentNode.next;
        currentNode.prev = null;
        currentNode.next = null;
    }
    
    private void addNodeAtTail(DLLNode currentNode){
        currentNode.next = tail;
        DLLNode tempNode = tail.prev;
        tail.prev = currentNode;
        currentNode.prev = tempNode;
        tempNode.next = currentNode;
        
    }
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */