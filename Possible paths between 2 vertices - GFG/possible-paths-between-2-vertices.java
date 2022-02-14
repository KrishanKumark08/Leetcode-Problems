// { Driver Code Starts
// Initial Template for Java
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
                // adj.get(v).add(u);
            }
            String[] S1 = br.readLine().trim().split(" ");
            int source = Integer.parseInt(S1[0]);
            int destination = Integer.parseInt(S1[1]);
            Solution obj = new Solution();
            System.out.println(obj.countPaths(V, adj, source, destination));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to count paths between two vertices in a directed graph.
    public int countPaths(int n, ArrayList<ArrayList<Integer>> graph, int source,
                   int destination) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited = new boolean[n];
        sourceToTarget(graph, source, visited, destination, new ArrayList<>(), answer);
        return answer.size();
    }
    
    private void sourceToTarget(ArrayList<ArrayList<Integer>> graph, int currentNode, boolean[] visited, int destination, List<Integer> currentPath, List<List<Integer>> answer){
        
        if(currentNode == destination){
            currentPath.add(currentNode);
            answer.add(new ArrayList<>(currentPath));
            currentPath.remove(currentPath.size() - 1);
            return ;
        }
        
        if(visited[currentNode] == true){
            return;
        }
        
        currentPath.add(currentNode);
        visited[currentNode] = true;
        
        for(Integer neighbour:graph.get(currentNode)){
            sourceToTarget(graph, neighbour, visited, destination, currentPath, answer);
        }
         
        currentPath.remove(currentPath.size() - 1);
        visited[currentNode] = false;
        return;
        
    }
    
    
}