//Stable Marriage Problem
class Solution {
    public static boolean prefers(int[][] women, int w, int m, int m1) {
        for (int i = 0; i < women[w].length; i++) {
            if (women[w][i] == m)
                return true;
            if (women[w][i] == m1)
                return false;
        }
        return false;
    }
    public int[] stableMarriage(int[][] men, int[][] women) {
        // code here
        int n = men.length;

        int[] wPartner = new int[n];

        for (int i = 0; i < n; i++) wPartner[i] = -1; 
        int[] mPartner = new int[n];
        for (int i = 0; i < n; i++) mPartner[i] = -1; 
        
        int[] next = new int[n]; 
        boolean[] freeMan = new boolean[n];
        
        for (int i = 0; i < n; i++) freeMan[i] = true; 

        int freeCount = n;

        while (freeCount > 0) {
            int m;
            for (m = 0; m < n; m++)
                if (freeMan[m])
                    break;

            int w = men[m][next[m]];
            next[m]++;

            if (wPartner[w] == -1) {
                wPartner[w] = m;
                mPartner[m] = w;
                freeMan[m] = false;
                freeCount--;
            }
            else {
                int m1 = wPartner[w];

                if (prefers(women, w, m, m1)) {
                    wPartner[w] = m;
                    mPartner[m] = w;

                    freeMan[m] = false;
                    freeMan[m1] = true;
                }
            }
        }

        return mPartner;
    }
}
