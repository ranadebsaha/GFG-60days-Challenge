import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        ArrayList<Integer> ans = new ArrayList<>();

        if(low > high) {
         return ans;
         }

       boolean[] present = new boolean[high - low + 1];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= low && arr[i] <= high) {
                present[arr[i] - low] = true;
            }
        }
        for (int i = 0; i <= high - low; i++) {
            if(!present[i]) {
                 ans.add(low + i);
            }
        }
        return ans;
    }
}
