class MyCircularQueue {
    int[] arr;
    int size;
    int front = -1;
    int rear = -1;
    public MyCircularQueue(int k) {
        size = k;
        arr = new int[size];
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            //System.out.println("Front = "+front+" Rear = "+rear + " Value = "+value+" Size = "+size);
            return false; // Check if Queue is Full
        }
        else if(front == -1){ // Check if Queue if Empty
            front = 0;
            rear = 0;
        }
        else if(rear == size - 1 && front != 0){ // To maintain the cyclic nature
            rear = 0;
        }
        else // Normal Flow
            rear++;
        //System.out.println("Front = "+front+" Rear = "+rear + " Value = "+value+" Size = "+size);
        arr[rear] = value;
        return true;
        
    }
    
    public boolean deQueue() {
        if(front == -1){ // To Check if Queue is Empty
            return false;
        }
        
        arr[front] = -1;
        if(front == rear){ // if there is only 1 element present
            front = rear = -1;
        }
        else if(front == size - 1){ // To maintain the cyclic nature
            front = 0;
        }
        else // Normal Flow
            front++;
        return true;
        
    }
    
    public int Front() {
        if(front == -1){ // To Check if Queue is Empty
            return -1;
        }
        return arr[front];
    }
    
    public int Rear() {
        if(rear == -1){ // To Check if Queue is Empty
            return -1;
        }
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return front == -1;
    }
    
    public boolean isFull() {
        return front == 0 && rear == size - 1 || front != 0 && size != 1 && rear == (front - 1)%(size - 1); // We are checking front != 0 because in modulus -> Modulus of any negative value 0 and it was failing for 1 test case // And we are checking for size != 1 because otherwise size - 1 will case exception 
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */