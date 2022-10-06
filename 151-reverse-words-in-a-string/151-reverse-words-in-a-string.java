class Solution {
    public String reverseWords(String s) {
        String ans = "";
        String temp = "";
        
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                if(temp.length() > 0 && temp.charAt(0) != ' ')
                    list.add(temp);
                temp = "";
            }
            else{
                temp = temp + s.charAt(i);
            }
        }
        
        list.add(temp);
        
        for(int i = list.size() - 1; i > 0; i--){
            ans = ans + list.get(i) + ' ';
        }
        
        ans = ans + list.get(0);
        
        return ans.trim();
    }
}