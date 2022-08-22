class Solution {
    public String countAndSay(int n) {
        
        String s = "1";
        
        while(n-- > 1){
            LinkedHashMap<Character, Integer> memo = new LinkedHashMap<>();
            
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
    }
}