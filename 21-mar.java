//Number of BST From Array
class Solution {
     static ArrayList<Integer> computeFact(int num) {
        ArrayList<Integer> fact = new ArrayList<>(Collections.nCopies(num + 1, 1));
        for (int i = 1; i <= num; i++)
            fact.set(i, fact.get(i - 1) * i);
        return fact;
    }


    static int catalan(int n, ArrayList<Integer> fact) {
        return fact.get(2 * n) / (fact.get(n) * fact.get(n + 1));
    }
    
    public ArrayList<Integer> countBSTs(int[] arr) {
        // Code here
         int n = arr.length;
        int[][] sorted = new int[n][2];

        for (int i = 0; i < n; i++) {
            sorted[i][0] = arr[i];
            sorted[i][1] = i;
        }
        Arrays.sort(sorted, Comparator.comparingInt(a -> a[0]));

        ArrayList<Integer> fact = computeFact(2 * n);

        ArrayList<Integer> numBSTs = new ArrayList<>(Collections.nCopies(n, 0));

        for (int i = 0; i < n; i++) {
            int j = sorted[i][1];
            numBSTs.set(j, catalan(i, fact) * catalan(n - i - 1, fact));
        }

        return numBSTs;
    }
}
