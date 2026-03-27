//Chocolates Pickup
class Solution {
    
    static int maxFromNextRow( int r, int c1, int c2, int m, int[][][] dp) {
        int[] dir = {-1, 0, 1};
        int max = 0;
        for( int i = 0; i < dir.length; i++ ) {
            for( int j = 0; j < dir.length; j++ ) {
                int d1 = dir[i];
                int d2 = dir[j];
                if( c1 + d1 >= 0 && c1 + d1 < m && c2 + d2 >= 0 && c2 + d2 < m ) {
                    max = Math.max(max, dp[r+1][c1+d1][c2+d2]);
                }
            }
        }
        return max;
    }
    
    public int maxChocolate(int grid[][]) {
        // code here
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        for( int c1 = 0; c1 < m ; c1++ ) {
            for( int c2 = 0; c2 < m ; c2++ ) {
                dp[n-1][c1][c2] = (grid[n-1][c1]) + ((c1 != c2) ? grid[n-1][c2] : 0) ; 
            }
        }
        
        for( int r = n-2; r >= 0; r-- ) {
            for( int c1 = 0; c1 < m ; c1++ ) {
                for( int c2 = 0; c2 < m ; c2++ ) {
                    dp[r][c1][c2] = (grid[r][c1]) + ((c1 != c2) ? grid[r][c2] : 0) ;
                    int max = maxFromNextRow(r, c1, c2, m, dp);
                    dp[r][c1][c2] += max;
                }
            }
            
        }
        return dp[0][0][m-1];
    }
}
