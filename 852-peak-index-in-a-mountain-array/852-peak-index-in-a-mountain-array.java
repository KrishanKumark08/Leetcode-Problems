class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        
        while(start < end){
            int mid = start + (end - start)/2;
            
            if(arr[mid] < arr[mid + 1]){
                start = mid + 1;
            }
            else
                end = mid; // Here Whether we are present on mid or on the decresing side of mountain -> we will move towards the mid of the array i.e towards Peak Index;
            // If we do mid - 1 then if we were present on mid then we might lose peak index
        }
        return end;
    }
}