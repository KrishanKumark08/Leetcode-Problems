class Solution {
    public int countSubstrings(String s) {
        List<String> list = new ArrayList<>();
        totalPalindrome(s, 0, s.length() - 1, list, new HashMap<String, Integer>());
        return list.size();
    }
    public void totalPalindrome(String s, int start, int end, List<String> list, HashMap<String, Integer> memo){
        if(start > end){
            return ;
        }
        
        String currentKey = start + "_" + end;
        if(memo.containsKey(currentKey))
            return ;
        
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