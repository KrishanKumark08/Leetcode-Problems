class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }
        return isPossible(s, set, new HashMap<String, Boolean>());
    }
    
    private boolean isPossible(String s, HashSet<String> set, HashMap<String, Boolean> memo){
        if(set.contains(s)){
            return true;
        }
        
        if(memo.containsKey(s)){
            return memo.get(s);
        }
        
        boolean ans = false;
        
        for(int i = 0; i < s.length(); i++){
            String sub = s.substring(0, i + 1);
            //System.out.println(sub);
            if(set.contains(sub)){
                ans = ans || isPossible(s.substring(i + 1), set, memo);
            }
        }
        memo.put(s, ans);
        return ans;
    }
    
}