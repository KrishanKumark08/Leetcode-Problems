// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();
        traverseMatrix(0, 0, m, n, new int[n][n], "", ans);
        return ans;
    }
    
    private static void traverseMatrix(int cRow, int cCol, int[][] m, int n, int vis[][], String currentAns, ArrayList<String> ans){
        
        if(cRow < 0 || cRow >= n || cCol < 0 || cCol >= n || m[cRow][cCol] == 0 || vis[cRow][cCol] == 1){
            return;
        }
        
        if(cRow == n - 1 && cCol == n - 1){
            ans.add(currentAns);
            return;
        }
        
        vis[cRow][cCol] = 1;
        traverseMatrix(cRow + 1, cCol, m, n, vis, currentAns + "D", ans);
        traverseMatrix(cRow, cCol - 1, m, n, vis, currentAns + "L", ans);
        traverseMatrix(cRow, cCol + 1, m, n, vis, currentAns + "R", ans);
        traverseMatrix(cRow - 1, cCol, m, n, vis, currentAns + "U", ans);
        vis[cRow][cCol] = 0;
    }
}