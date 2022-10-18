class Solution {
    public String countAndSay(int n) {
        
        String s = "1";
        while(n-- > 1){
            int i = 0;
            String temp = "";
            while(i < s.length()){
                int count = 0;
                char currentChar = s.charAt(i);
                while(i < s.length() && currentChar == s.charAt(i)){
                    count++;
                    i++;
                }
                
                temp = temp + "" + count + "" + currentChar;
            }
            s = temp;
        }
        return s;
        // T.C = 
        // S.C = 
    }
}