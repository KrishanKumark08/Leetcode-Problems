class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int max=0;
        int prev=0;
        for(int i=0;i<s.length();i++)
        {
            char key=s.charAt(i);
            if(map.containsKey(key))
            {
                if(map.get(key)+1>prev)
                prev=map.get(key)+1;
                map.put(key,i);
                max=Math.max(max,i-prev+1);
            }
            else
            {
                map.put(key,i);
                max=Math.max(max,i-prev+1);
            }
            //System.out.println(max);
        }
        return max;
    }
}