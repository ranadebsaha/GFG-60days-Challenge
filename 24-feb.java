//Longest Span in two Binary Arrays
import java.util.HashMap;

class Solution {
    public int equalSumSpan(int[] a1,int[] a2) {
        int maxSpan = 0;
        int prefixSum = 0;
        
        HashMap<Integer, Integer> map =new HashMap<>();
        
        for (int i = 0; i < a1.length; i++) {
           
            prefixSum += (a1[i] - a2[i]);
            
           
            if (prefixSum == 0) {
                maxSpan = i + 1;
            }
            
      
            if (map.containsKey(prefixSum)) {
              
                int previousIndex = map.get(prefixSum);
                maxSpan = Math.max(maxSpan, i - previousIndex);
            } else {
              
                map.put(prefixSum, i);
            }
        }
        
        return maxSpan;
    }
}
