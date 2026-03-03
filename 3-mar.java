//Longest subarray with Atmost two distinct integers
import java.util.HashMap;

class Solution {
    public int totalElements(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < arr.length; right++) {
            
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            
            while (map.size() > 2) {
                int leftElement = arr[left];
                map.put(leftElement, map.get(leftElement) - 1);
                
                if (map.get(leftElement) == 0) {
                    map.remove(leftElement);
                }
                left++; 
            }
            
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
