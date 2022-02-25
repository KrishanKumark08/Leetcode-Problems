class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {
        
        int n = text1.length();
        int m = text2.length();
        
        int[][] memo = new int[n + 1][m + 1];
        
        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    memo[i][j] = 1 + memo[i + 1][j + 1];
                }
                else{
                    memo[i][j] = Math.max(memo[i][j + 1], memo[i + 1][j]);
                }
            }
        }
        
        int i = 0;
        int j = 0;
        String str = "";
        while(i != n && j != m){
            if(text1.charAt(i) == text2.charAt(j)){
                str = str + text1.charAt(i);
                i = i + 1;
                j = j + 1;
            }
            else{
                if(memo[i][j + 1] >= memo[i + 1][j]){
                    str = str + text2.charAt(j);
                    j = j + 1;
                }
                else{
                    str = str + text1.charAt(i);
                    i = i + 1;
                }
            }
           // System.out.println(str);
        }
        
        while(i != n){
            str = str + text1.charAt(i);
            i++;
        }
        
        while(j != m){
            str = str + text2.charAt(j);
            j++;
        }
        
//         if(memo[0][0] == m ){
//             return text1;
//         }
//         if(memo[0][0] == n){
//             return text2;
//         }
         
//         if(memo[0][0] == 0){
//             return text1 + text2;
//         }
        return str;
        
    }
}