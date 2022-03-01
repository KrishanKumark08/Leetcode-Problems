// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> recStack = new HashSet<>();
        
        for(int currentVertex = 0; currentVertex < V; currentVertex++){
            if(!visited.contains(currentVertex)){
                if(hasCycle(currentVertex, visited, recStack, adj, V)){
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    private boolean hasCycle(int currentVertex, HashSet<Integer> visited, HashSet<Integer> recStack, ArrayList<ArrayList<Integer>> adj, int parentVertex){
        visited.add(currentVertex);
        recStack.add(currentVertex);
        
        for(int neighbour:adj.get(currentVertex)){
            if(!visited.contains(neighbour) && neighbour!= parentVertex){
                if(hasCycle(neighbour, visited, recStack, adj, currentVertex)){
                    return true;
                }
            }
            else if(recStack.contains(neighbour) && neighbour!= parentVertex){
                return true;
            }
        }
        
        recStack.remove(currentVertex);
        return false;
    }
    
}