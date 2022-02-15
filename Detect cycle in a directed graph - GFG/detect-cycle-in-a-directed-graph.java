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
        
        HashSet<Integer> visited = new HashSet<>(); // BEcause If vertex are a b c then we can't use array
        HashSet<Integer> recStack = new HashSet<>();
        
        for(int currentVertex = 0; currentVertex < V; currentVertex++){
            if(visited.contains(currentVertex)){
                continue;
            }
            
            if(checkIsCyclic(currentVertex, visited, recStack, adj) == true){
                return true;
            }
            
        }
        
        return false;
        
    }
    
    private boolean checkIsCyclic(int currentVertex, HashSet<Integer> visited, HashSet<Integer> recStack, ArrayList<ArrayList<Integer>> adj){
        visited.add(currentVertex);
        recStack.add(currentVertex);
        
        
        for(Integer neighbour:adj.get(currentVertex)){
            if(!visited.contains(neighbour)){
                if(checkIsCyclic(neighbour, visited, recStack, adj) == true){
                    return true;
                }
            }
            else if(recStack.contains(neighbour)){
                    return true;
                }
        }
        
        recStack.remove(currentVertex);
        return false;
    }
    
    
}