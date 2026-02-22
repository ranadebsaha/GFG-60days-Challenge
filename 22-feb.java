import java.util.HashMap;
class Solution {
    public long subarrayXor(int arr[],int k) {
        long count =0;
        int prefix_xor =0;
        HashMap<Integer, Integer> map= new HashMap<>();
        
        map.put(0, 1);
        
        for(int i = 0; i< arr.length; i++){
            prefix_xor ^= arr[i];
            
            int target =prefix_xor ^ k;
            
            if(map.containsKey(target)) {
                count +=map.get(target);
            }
            map.put(prefix_xor, map.getOrDefault(prefix_xor, 0) + 1);
        }
        
        return count;
    }
}
