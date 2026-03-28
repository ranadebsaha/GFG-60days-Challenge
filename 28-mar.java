//Articulation Point - II
class Solution {
    static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        // code here
        int[] disc = new int[V], low = new int[V], parent = new int[V], childrenCount = new int[V];
        boolean[] visited = new boolean[V], ap = new boolean[V];
        for (int i = 0; i < V; i++) parent[i] = -1;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) tarjan(i, adj, visited, disc, low, parent, childrenCount, ap);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) if (ap[i]) result.add(i);
        if (result.isEmpty()) result.add(-1);
        
        return result;
    }
    private static void tarjan(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited,
                                     int[] disc, int[] low, int[] parent, int[] childrenCount, boolean[] ap) {

        int[][] stack = new int[visited.length * 2][3];
        int top = 0, time = 0;

        stack[top++] = new int[]{start, 0, 0};

        while (top > 0) {
            int u = stack[top - 1][0], idx = stack[top - 1][1], state = stack[top - 1][2];
            top--;

            if (state == 0) {
                if (!visited[u]) {
                    visited[u] = true;
                    disc[u] = low[u] = ++time;
                }

                if (idx < adj.get(u).size()) {
                    int v = adj.get(u).get(idx);

                    stack[top++] = new int[]{u, idx + 1, 0};

                    if (!visited[v]) {
                        parent[v] = u;
                        childrenCount[u]++;
                        stack[top++] = new int[]{v, 0, 0};
                    } else if (v != parent[u]) {
                        low[u] = Math.min(low[u], disc[v]);
                    }
                } else {
                    stack[top++] = new int[]{u, 0, 1};
                }
            } else {
                if (top > 0) {
                    int p = stack[top - 1][0];
                    low[p] = Math.min(low[p], low[u]);
                    if (parent[p] != -1 && low[u] >= disc[p]) ap[p] = true;
                } else if (childrenCount[start] > 1) {
                    ap[start] = true;
                }
            }
        }
    }
}
