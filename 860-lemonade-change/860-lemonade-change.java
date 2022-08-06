class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        for(int i = 0;i < bills.length; i++){
            if(bills[i] == 5){
                memo.put(5, memo.getOrDefault(5, 0) + 1);
            }
            else if(bills[i] == 10){
                if(memo.containsKey(5) && memo.get(5) >= 1){
                    memo.put(10, memo.getOrDefault(10, 0) + 1);
                    memo.put(5, memo.getOrDefault(5, 0) - 1);
                }
                else{
                    return false;
                }
            }
            else if(bills[i] == 20){
                if(memo.containsKey(10) && memo.containsKey(5) && memo.get(5) >= 1 && memo.get(10) >= 1){
                    memo.put(10, memo.getOrDefault(10, 0) - 1);
                    memo.put(5, memo.getOrDefault(5, 0) - 1);
                }
                else if(memo.containsKey(5) && memo.get(5) >= 3){
                    memo.put(5, memo.getOrDefault(5, 0) - 3);
                    
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}