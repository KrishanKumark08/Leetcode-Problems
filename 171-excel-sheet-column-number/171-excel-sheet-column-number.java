class Solution {
    public int titleToNumber(String columnTitle) {
        int answer = ((int)columnTitle.charAt(0) - 64);
        for(int i = 1; i < columnTitle.length(); i++){
            answer = answer*26 + ((int)columnTitle.charAt(i) - 64);
        }
        
        return answer;
        
    }
}