class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        for(int num:nums){
            memo.put(num, memo.getOrDefault(num, 0) + 1);
        }
        
        // Comparator<Map.Entry<Integer, Integer>> valueComparator = new Comparator(){
        //     public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
        //         return e1.getValue() - e2.getValue();
        //     }
        // };
        
        List<Map.Entry<Integer, Integer>> listOfEntries = new ArrayList<>(memo.entrySet());
        
        Collections.sort(listOfEntries, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
                return e2.getValue() - e1.getValue();
            }
        });

        System.out.println(listOfEntries);
        
        
        
        int[] ans = new int[k];
        
        for(int i = 0; i < k; i++){
            ans[i] = listOfEntries.get(i).getKey();
        }
        
        return ans;
        
    }
}