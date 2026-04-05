//Target Sum
class Solution {
    public int totalWays(int[] arr, int target) {
        // code here
        int N = arr.length;
        int totalSum = 0;

        for (int x : arr)
            totalSum += x;

        int size = 2 * totalSum + 1;
        
        int[] prev = new int[size];
        int[] curr = new int[size];

        prev[totalSum] = 1;

        for (int i = 1; i <= N; i++) {

            Arrays.fill(curr, 0);
            int val = arr[i - 1];

            for (int sum = 0; sum < size; sum++) {


                if (sum + val < size)
                    curr[sum + val] += prev[sum];

        
                if (sum - val >= 0)
                    curr[sum - val] += prev[sum];
            }

            prev = curr.clone();
        }

        return prev[target + totalSum];
    }
}
