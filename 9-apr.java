//Intersection of Two Sorted Arrays

class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int m = a.length;
        int n = b.length;

        int i = 0, j = 0;
        while (i < m && j < n) {

            if (i > 0 && a[i - 1] == a[i]) {
                i++;
                continue;
            }

            // Skip the smaller
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            }

            else {
                res.add(a[i]);
                i++;
                j++;
            }
        }

        return res;
    }
}
