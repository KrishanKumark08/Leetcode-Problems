class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<String>();
        
        if(digits.length() == 0){
            return answer;
        }
        
        HashMap<Character, String> memo = new HashMap<>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
            
        }};
        
        generateAllCombinations(digits, 0, "", answer, memo);
        
        return answer;
        
    }
    
    private void generateAllCombinations(String digits, int currentIndex, String currentAns, List<String> answer, HashMap<Character, String> memo){
        
        if(currentIndex == digits.length()){
            answer.add(currentAns);
            return;
        }
        
        char currentChar = digits.charAt(currentIndex);
        
        String currentString = memo.get(currentChar);
        
        for(int i = 0; i < currentString.length(); i++){
            generateAllCombinations(digits, currentIndex + 1, currentAns + currentString.charAt(i), answer, memo);
        }
        
        return;
        
    }
    
}