class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        
        int sum = 0;
        for(int i = 0; i < n; i++){
            leftSum[i] = sum;
            sum += nums[i];
        }
        
        sum = 0;
        for(int i = n - 1; i >= 0; i--){
            rightSum[i] = sum;
            sum += nums[i];
        }
        
//         int start = 0;
//         int end = n - 1;
        
//         int pivotIndex = -1;
//         while(start <= end){
//             int mid = start + (end - start)/2;
//             System.out.println("Mid = "+mid+" leftSum = "+leftSum[mid]+" rightSum = "+rightSum[mid]);
//             if(leftSum[mid] == rightSum[mid]){
//                 pivotIndex = mid;
//                 end = mid - 1;
//             }
//             else if(leftSum[mid] > rightSum[mid]){
//                 start = mid + 1;
//             }
//             else
//                 end = mid - 1;
//         }
//         return pivotIndex;
        
        for(int i = 0; i < n; i++){
            if(leftSum[i] == rightSum[i]){
                return i;
            }
        }
        return -1;
    }
}
 