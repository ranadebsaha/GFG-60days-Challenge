class Solution {
    public int countSquare(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] freq = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                freq[i][j] = mat[i - 1][j - 1] 
                           + freq[i - 1][j] 
                           + freq[i][j - 1] 
                           - freq[i - 1][j - 1];
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int maxSideLength = Math.min(n - i + 1, m - j + 1);
                
                for (int k = 1; k <= maxSideLength; k++) {
                    int r2 = i + k - 1;
                    int c2 = j + k - 1;
                    
                    int currentSum = freq[r2][c2] 
                                   - freq[i - 1][c2] 
                                   - freq[r2][j - 1] 
                                   + freq[i - 1][j - 1];
                    
                    if (currentSum == x) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
