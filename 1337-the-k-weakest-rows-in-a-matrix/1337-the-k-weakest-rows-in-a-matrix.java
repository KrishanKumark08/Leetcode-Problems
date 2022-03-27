class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int res[]=new int[k];
        for(int i=0;i<mat.length;i++){
            int count=0;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==1)
                    count++;
                else break;
            }
            map.put(i,count);
        }
        
        List<Map.Entry<Integer,Integer>> list=new LinkedList<Map.Entry<Integer,Integer>>(map.entrySet());
        
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer,Integer> a,Map.Entry<Integer,Integer> b){
                if(a.getValue()==b.getValue())
                    return a.getKey()-b.getKey();
                return a.getValue()-b.getValue();
            }
        });
        int i=0;
        for(Map.Entry<Integer,Integer> mp:list)
        {
            res[i++]=mp.getKey();
            if(i==k)
                break;
        }
        return res;
    }
}