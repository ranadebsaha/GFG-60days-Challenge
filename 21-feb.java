import java.util.*;
class Solution {
    public int hIndex(int[] citations) {
        // code here
        Arrays.sort(citations);
        int h=0,i;
        int len=citations.length;
        if(citations[len-1]==0){
            return 0;
        }
            for(i=len-1;i>=0;i--){
                if(citations[i]>=h+1){
                    h++;
                }
                
            }
            
        
        return h;
    }
}
