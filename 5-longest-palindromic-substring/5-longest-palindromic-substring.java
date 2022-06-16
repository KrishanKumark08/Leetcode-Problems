class Solution {
    public String longestPalindrome(String s) {
        ArrayList<String> list = new ArrayList<>();
        totalPalindrome(s, 0, s.length() - 1, list, new HashMap<String, Integer>());
        if(isPalindrome(s, 0, s.length() - 1))
            return s;
        int size = 0;
        String longest = "";
        for(String k:list){
            if(k.length() > size){
                longest = k;
                size = k.length();
            }
        }
        return longest;
    }
    public void totalPalindrome(String s, int start, int end, ArrayList<String> list, HashMap<String, Integer> memo){
        if(start > end){
            return ;
        }
        
        if(isPalindrome(s, start, end) == true){
            list.add(s.substring(start,end+1));
            return ;
        }
        
        String currentKey = start + "_" + end;
        if(memo.containsKey(currentKey))
            return ;
        
        // int ans  = 2001;
        
        for(int currentCut = start; currentCut <= end; currentCut++){
            if(isPalindrome(s, start, currentCut) == true){
                list.add(s.substring(start,currentCut + 1));
                totalPalindrome(s, currentCut + 1, end, list, memo);
            }
        }
        
        memo.put(currentKey, 0);
        return ;
        
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}