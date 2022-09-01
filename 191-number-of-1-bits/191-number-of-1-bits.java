public class Solution {
 
    public int hammingWeight(int n) {
        
		int setBitCount = 0;
        
		while (n != 0) {
            int rmst = (n & -n);
            n = n - rmst;
            ++setBitCount;
        }
		
        return setBitCount;
    }
}