Max Xor Subarray of size K
class Solution {
    static int maxSubarrayXOR(int[] arr, int k) {
        int n = arr.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }

        int maxXor = 0;

        for (int i = 0; i <= n - k; i++) {
            int j = i + k - 1;
            int currXor = prefix[j + 1] ^ prefix[i];

            maxXor = Math.max(maxXor, currXor);
        }

        return maxXor;
    }
}
