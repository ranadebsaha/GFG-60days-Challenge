//Count increasing Subarrays
class Solution {
    public int countIncreasing(int[] arr) {
        // code here
        int n = arr.length;
        int count = 0;
        int len = 1;

        for (int i = 1; i < n; i++) {
            
            if (arr[i] > arr[i - 1]) {
                len++;
            } 
            
            else {
                
                count += (len * (len - 1)) / 2;
                len = 1;
            }
        }

        count += (len * (len - 1)) / 2;

        return count;
    }
}
