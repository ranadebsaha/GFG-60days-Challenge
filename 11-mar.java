//Sum of subarray minimums
class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int n = arr.length;
        int[] dp = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) right[i] = i;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                right[st.pop()] = i;
            }
            st.push(i);
        }

        dp[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int r = right[i];
            if (r == i) {
                dp[i] = (n - i) * arr[i];
            } else {
                dp[i] = (r - i) * arr[i] + dp[r];
            }
        }

        int sum = 0;
        for (int val : dp) sum += val;
        return sum;
    }
}
