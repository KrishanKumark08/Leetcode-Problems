class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        int left = 0;
        
        HashMap<Character, Integer> memo = new HashMap<>();
        
        for(int right = 0; right < s.length() ; right++){
            char currentChar = s.charAt(right);
            
            if(memo.containsKey(currentChar) && memo.get(currentChar) >= left){
                left = memo.get(currentChar) + 1;
            }
            
            int a = right - left + 1;
            memo.put(currentChar, right);
            answer = Math.max(answer, a);
        
        }
        
        return answer;
        
    }
}