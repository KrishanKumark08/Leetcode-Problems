// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> graph) 
    {
        int[] inDegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int[] answer = new int[V];
        int index = 0;
       
        for(int i = 0; i < graph.size(); i++){
            for(int neighbour:graph.get(i)){
                inDegree[neighbour]++;
            }
        }
       
       
        int ans = 0;
        
        for(int i = 0;i < V; i++){
            if(inDegree[i] == 0){
                queue.add(i);
                answer[index] = i;
                index++;
                ans++;
            }
        }
        
        
        while(!queue.isEmpty()){
            int currentVertex = queue.remove();
            
            if(visited.contains(currentVertex)){
                continue;
            }
            
            visited.add(currentVertex);
            for(int neighbour:graph.get(currentVertex)){
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0){
                    queue.add(neighbour);
                    answer[index] = neighbour;
                    index++;
                    ans++;
                }
            }
        }
        
            return answer;
    }
}