class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        for(int ans : answers){
            memo.put(ans, memo.getOrDefault(ans, 0) + 1);
        }
        
        int count = 0;
        for(int key:memo.keySet()){
                count += ((int)Math.ceil((double)memo.get(key) / (double)(key + 1))) * (key + 1);
        }
        return count;
    }
}