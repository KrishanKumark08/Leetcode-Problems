class Solution {
    public boolean backspaceCompare(String s, String t) {
        String newS = "";
        String newT = "";
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '#'){
                if(newS.length() == 1){
                    newS = "";
                    continue;
                }
                else if(newS.length() > 0){
                    newS = newS.substring(0, newS.length() - 1);
                }
            }
            else{
                newS += s.charAt(i);
            }
        }
        
        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) == '#'){
                if(newT.length() == 1){
                    newT = "";
                    continue;
                }
                else if(newT.length() > 0){
                    newT = newT.substring(0, newT.length() - 1);
                }
            }
            else{
                newT += t.charAt(i);
            }
        }
        
        System.out.println(newS);
        System.out.println(newT);
        
        return newS.equals(newT);
    }
}