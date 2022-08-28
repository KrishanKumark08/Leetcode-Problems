class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
      HashSet<String> set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }
        List<String> ans = new ArrayList<>();
        isPossible(s, set, new HashMap<String, Boolean>(), "", ans);
        return ans;
    }
    
    private void isPossible(String s, HashSet<String> set, HashMap<String, Boolean> memo, String currAns, List<String> ans){
        if(set.contains(s)){
            String str = currAns +" " + s;
            ans.add(str.substring(1));
        }
        
        for(int i = 0; i < s.length(); i++){
            String sub = s.substring(0, i + 1);
            if(set.contains(sub)){
                isPossible(s.substring(i + 1), set, memo, currAns + " " + sub, ans);
            }
        }
        
    }
}