
class Solution {
    public static int overlapInt(int[][] arr) {
         int max_val= 0;
         for (int[] interval :arr) {
         max_val =Math.max(max_val,interval[1]);
        }
        int[] diff = new int[max_val+ 2];
        for (int[] interval : arr) {
             diff[interval[0]]++;
             diff[interval[1] + 1]--;
        }

        int res = 0;
        int current =0;

        for (int i = 0; i <= max_val; i++) {
            current += diff[i];
        res = Math.max(res, current);
        }

        return res;
    }
}
