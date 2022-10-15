//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends

class Meeting implements Comparable<Meeting>{
    int startTime;
    int endTime;
    int index;
    
    Meeting(int start, int end, int index){
        this.startTime = start;
        this.endTime = end;
        this.index = index;
    }
    
    public int compareTo(Meeting o){
        if(this.endTime != o.endTime){
            return this.endTime - o.endTime;
        }
        return this.index - o.index;
    }
    
}


class Solution {
    public static ArrayList<Integer> maxMeetings(int n, int[] start, int[] end) {
        // code here
        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        
        for(int i = 0; i < n; i++){
            pq.add(new Meeting(start[i], end[i], i));
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        int lastTime = -1;
        
        while(!pq.isEmpty()){
            Meeting currentMeeting = pq.remove();
            if(currentMeeting.startTime > lastTime){
                ans.add(currentMeeting.index + 1);
                lastTime = currentMeeting.endTime;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
        
