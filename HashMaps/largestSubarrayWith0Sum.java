class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> memo = new HashMap<>();
        int prefixSum = 0;
        int answer = 0;
        
        memo.put(prefixSum, -1);
        
        for(int i = 0; i < n; i++){
            int currentVal = arr[i];
            prefixSum += currentVal;
            
            if(memo.containsKey(prefixSum)){
                int temp = i - memo.get(prefixSum);
                answer = Math.max(answer, temp);
            }
            else{
                memo.put(prefixSum, i);
            }
        }
        
        return answer;
        
    }
}
