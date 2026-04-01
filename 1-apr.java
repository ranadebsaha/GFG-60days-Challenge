//Consecutive 1's not allowed
class Solution {
    static int[][] multiply(int[][] v1, int[][] v2) {
        int[][] ans = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    ans[i][j] += v1[i][k] * v2[k][j];
                }
            }
        }

        return ans;
    }

    static int[][] power(int[][] v, int n) {
        if (n == 0) {
            return new int[][] { { 1, 0 }, { 0, 1 } };
        }

        int[][] res = power(v, n / 2);
        res = multiply(res, res);

        if (n % 2 == 1) {
            res = multiply(res, v);
        }

        return res;
    }
    int countStrings(int n) {
        // code here
        if (n == 2)
            return 3;
        if (n == 1)
            return 2;

        int[][] v = { { 1, 1 }, { 1, 0 } };
        int[][] p = power(v, n - 2);

        int ans = p[0][0] * 3 + p[0][1] * 2;
        return ans;
    }
}
