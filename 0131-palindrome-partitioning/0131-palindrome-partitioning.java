class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        palindromePartitions(s, 0, s.length() - 1, ans, new ArrayList<>());
        return ans;
    }
    
    private void palindromePartitions(String s, int start, int end, List<List<String>> ans, List<String> currAns){
        if(start > end){
            ans.add(new ArrayList<>(currAns));
            return;
        }
        
        
        for(int k = start; k <= end; k++){
            if(isPalindrome(s, start, k)){
                currAns.add(s.substring(start, k + 1));
                palindromePartitions(s, k + 1, end, ans, currAns);
                currAns.remove(currAns.size() - 1);
            }
        }
        
    }
    
    private boolean isPalindrome(String s, int start, int end){
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