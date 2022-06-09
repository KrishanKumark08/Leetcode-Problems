// { Driver Code Starts
import java.util.Scanner;

class GfG
{
	public static void main(String args[])
	{
		 Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
		 {
			MyQueue obj = new MyQueue();
			int Q = sc.nextInt();
			while(Q>0)
			{
				int QueryType = 0;
				QueryType = sc.nextInt();
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					
					obj.push(a);
					
				}else if(QueryType == 2)
				{
				System.out.print(obj.pop()+" ");
				}
				Q--;
			}
			System.out.println("");
			t--;
		 }
	}
}



// } Driver Code Ends




class MyQueue {

    int size = 100005;
    int front, rear;
	int arr[] = new int[size];

    MyQueue()
	{
		front=0;
		rear=0;
	}
	
	//Function to push an element x in a queue.
	void push(int x)
	{
	    if(rear == size){
	        System.out.println("Queue is Full");
	    }
	    arr[rear] = x;
	    rear++;
	} 

    //Function to pop an element from queue and return that element.
	int pop()
	{
		if(front == rear){
		    return -1;
		}
		int ele = arr[front];
		arr[front] = -1;
		front++;
		if(front == rear){
		    front = 0;
		    rear = 0;
		    
		}
		return ele;
	} 
	
	int front(){
	    if(front == rear){
	        return -1;
	    }
	    return arr[front];
	}
	
	boolean isEmpty(){
	    return front == rear;
	}
	
	
}



