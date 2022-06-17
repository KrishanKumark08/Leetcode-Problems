class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int answer = 0;
        HashMap<Character, Integer> memo = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            
            if(memo.containsKey(currentChar) && left <= memo.get(currentChar)){
                left = memo.get(currentChar) + 1;
            }
            memo.put(currentChar, i);
            answer = Math.max(answer, i - left + 1);
            
        }
        
        return answer;
        
    }
}