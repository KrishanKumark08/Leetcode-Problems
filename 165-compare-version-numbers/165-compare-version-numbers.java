class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        
        int n = str1.length;
        int m = str2.length;
        
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        
        for(int i = 0; i < n; i++){
            arr1[i] = Integer.parseInt(str1[i]);
        }
        
        for(int i = 0; i < m; i++){
            arr2[i] = Integer.parseInt(str2[i]);
        }
        
        int i = 0;
        int j = 0;
        while(i < n && j < m){
            if(arr1[i] > arr2[j]){
                return 1;
            }
            else if(arr1[i] < arr2[j]){
                return -1;
            }
            i++;
            j++;
        }
        
        if(i == n){
            while(j < m){
                if(arr2[j] != 0){
                    return -1;
                }
                j++;
            }
        }
        
        if(j == m){
            while( i < n){
                if(arr1[i] != 0){
                    return 1;
                }
                i++;
            }
        }
        
        return 0;
        
    }
}