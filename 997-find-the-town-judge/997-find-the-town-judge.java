class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int trusts = trust.length;
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i =0; i < n + 1; i++)
        {
            graph.add(new ArrayList<>());
        }
        
        HashSet<Integer> doingTrust = new HashSet<>();
        
        for(int i = 0; i < trusts; i++){
            int v1 = trust[i][0];
            int v2 = trust[i][1];
            graph.get(v2).add(v1);
            doingTrust.add(v1);
        }
        
        for(int i = 1; i <= n; i++){
            if((graph.get(i).size()) == n - 1 && !doingTrust.contains(i)){
                return i;
            }
        }
        
        return -1;
        
    }
}