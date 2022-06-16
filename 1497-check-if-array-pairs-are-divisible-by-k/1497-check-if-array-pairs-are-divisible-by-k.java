class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        for(int ele:arr){
            int remainder = ( (ele % k) + k) % k;
            memo.put(remainder, memo.getOrDefault(remainder, 0) + 1);
        }
        
        for(int key:memo.keySet()){
            if(key == 0){
                if(memo.get(key) % 2 != 0){
                    return false;
                }
            } 
            else if(!memo.containsKey(k - key)){
                return false;
            }
            else if(!memo.get(key).equals(memo.get(k - key))){
                // memo.get(key) != memo.get(k - key) Gives the wrong answer
                return false;
            } 
        }
        
        return true;
        
    }
}