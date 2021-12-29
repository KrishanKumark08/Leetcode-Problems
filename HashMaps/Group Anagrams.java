class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> memo = new HashMap<>();
        
        for(int i=0; i<strs.length; i++){
            String str = strs[i];
            
            HashMap<Character, Integer> map = new HashMap<>();
            
            for(int j=0; j<str.length(); j++){
                char currentValue = str.charAt(j);
                
                map.put(currentValue, map.getOrDefault(currentValue, 0) + 1);
                
            }
            
            if(memo.containsKey(map)){
                List<String> list = memo.get(map);
                list.add(str);
                memo.put(map, list);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(str);
                memo.put(map, list);
            }
        }
        //System.out.println(memo.values());
        // Map.values returns List of Values present in HashMap
        return new ArrayList<List<String>>(memo.values());
        
    }
}
