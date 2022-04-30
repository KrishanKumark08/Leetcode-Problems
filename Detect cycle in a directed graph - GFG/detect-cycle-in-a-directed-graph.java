// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = calculateIndegree(adj, V);
        
        Queue<Integer> queue = new LinkedList<>();
        int ans = 0;
        HashSet<Integer> visited = new HashSet<>();
        
        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0){
                queue.add(i);
                ans++;
            }
        }
        
        while(!queue.isEmpty()){
            int currentVertex= queue.remove();
            
            if(visited.contains(currentVertex)){
                continue;
            }
            
            visited.add(currentVertex);
            
            for(int neigh:adj.get(currentVertex)){
                inDegree[neigh]--;
                if(inDegree[neigh] == 0){
                    queue.add(neigh);
                    ans++;
                }
            }
            
        }
        return ans!=V;
    }   
    
    private int[] calculateIndegree(ArrayList<ArrayList<Integer>> adj, int V){
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int neighbour:adj.get(i)){
                indegree[neighbour]++;
            }
        }
        return indegree;
    }
}