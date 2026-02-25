//Longest Subarray with Majority Greater than K
import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int ans = 0;
        int prefixSum = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            prefixSum += (arr[i] > k) ? 1 : -1;
            if (prefixSum > 0) {
                ans = Math.max(ans, i + 1);
            } else {
                if (map.containsKey(prefixSum - 1)) {
                    ans = Math.max(ans, i -map.get(prefixSum - 1));
                }
            }
            
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        
        return ans;
    }
}
