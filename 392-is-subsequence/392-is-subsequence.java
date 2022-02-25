class Solution {
    public boolean isSubsequence(String s, String t) {
        
        if(s.length() == 0){
            return true;
        }
        
        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == s.charAt(0)){
                s = s.substring(1);
            }
            
            if(s.equals("")){
                return true;
            }
            
        }
        
        if(s.equals("")){
            return true;
        }
        
        return false;
        
    }
}