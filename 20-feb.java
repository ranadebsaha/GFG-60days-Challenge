import java.util.*;

class Solution {
    public String findLargest(int[] arr) {
        int n =arr.length;
        String[] sArr =new String[n];

        for (int i = 0; i < n; i++) {
            sArr[i] =String.valueOf(arr[i]);
        }
        Arrays.sort(sArr, (s1, s2) ->(s2 + s1).compareTo(s1 + s2));

        if (sArr[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : sArr) {
            sb.append(s);
        }

        return sb.toString();
    }
}
