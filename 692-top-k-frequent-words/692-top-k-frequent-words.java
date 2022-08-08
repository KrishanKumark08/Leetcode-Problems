class Pair implements Comparable<Pair>{
    String word;
    int count;
    Pair(String word, int count){
        this.word = word;
        this.count = count;
    }
    
    public int compareTo(Pair o){
        if(this.count == o.count){
            return -this.word.compareTo(o.word);
        }
        return this.count - o.count;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        HashMap<String, Integer> memo = new HashMap<>();
        
        for(int i = 0; i < words.length; i++){
            memo.put(words[i], memo.getOrDefault(words[i], 0) + 1);
        }
        
        for(String key:memo.keySet()){
            pq.add(new Pair(key, memo.get(key)));
            if(pq.size() > k){
                pq.remove();
            }
        }
        
        List<String> ans = new ArrayList<>();
        
        while(!pq.isEmpty()){
            Pair pair = pq.remove();
            System.out.println(pair.word + " " + pair.count);
            ans.add(pair.word);
        }
        
        Collections.reverse(ans);
        
        return ans;
        
    }
}