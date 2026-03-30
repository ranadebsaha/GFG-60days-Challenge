//Minimum cost to connect all houses in a city
class DSU {
    private int[] parent;
    private int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 1);
    }

    public int find(int i) {
        if (parent[i] == -1)
            return i;
        return parent[i] = find(parent[i]);
    }

    public void unite(int x, int y) {
        int s1 = find(x);
        int s2 = find(y);

        if (s1 != s2) {
            if (rank[s1] < rank[s2]) {
                parent[s1] = s2;
            } else if (rank[s1] > rank[s2]) {
                parent[s2] = s1;
            } else {
                parent[s2] = s1;
                rank[s1] += 1;
            }
        }
    }
}


class Solution {

    public int minCost(int[][] houses) {
        // code here
         int n = houses.length;

        List<int[]> edgeList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cost = Math.abs(houses[i][0] - houses[j][0]) +
                           Math.abs(houses[i][1] - houses[j][1]);
                edgeList.add(new int[]{cost, i, j});
            }
        }

        edgeList.sort(Comparator.comparingInt(a -> a[0]));

        DSU s = new DSU(n);

        int ans = 0, count = 0;

        for (int[] edge : edgeList) {
            int w = edge[0];
            int x = edge[1];
            int y = edge[2];

            if (s.find(x) != s.find(y)) {
                s.unite(x, y);
                ans += w;
                count++;
            }

            if (count == n - 1) {
                break;
            }
        }

        return ans;
    }
}
