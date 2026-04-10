//Sorted subsequence of size 3

class Solution {
    public List<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        
        if (n < 3) return res;

        int[] smaller = new int[n];
        int[] greater = new int[n];
        
        Arrays.fill(smaller, -1);
        Arrays.fill(greater, -1);

        int min_idx = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[min_idx]) {
                min_idx = i;
            } else {
                smaller[i] = min_idx;
            }
        }

        int max_idx = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= arr[max_idx]) {
                max_idx = i;
            } else {
                greater[i] = max_idx;
            }
        }

        for (int i = 0; i < n; i++) {
            if (smaller[i] != -1 && greater[i] != -1) {
                res.add(arr[smaller[i]]);
                res.add(arr[i]);
                res.add(arr[greater[i]]);
                return res;
            }
        }

        return res;
    }
}
