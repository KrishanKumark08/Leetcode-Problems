class Solution {
    public int mySqrt(int x) {
        if(x == 1){
            return 1;
        }
        int start = 0;
        int end = x / 2;
        
        int ans = -1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            long square = (long) mid * (long) mid;
            //long square = mid*mid; It did not got submitted due to this because i have to convert both of them to long before to get the result in long
            if(square == x){
                return mid;
            }
            
            if(square < x){
                ans = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        
        return ans;
        
    }
}