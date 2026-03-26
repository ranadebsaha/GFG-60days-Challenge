//Number of Ways to Arrive at Destination
class Solution {
    public int countPaths(int V, int[][] edges) {
        // code here
        int MOD = (int)(1e9 + 7);
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }
        
        long[] dist = new long[V];
        Arrays.fill(dist, Long.MAX_VALUE);
        int[] ways = new int[V];

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0});
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int) curr[1];
            if (d > dist[u]) continue;
            
            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                long w = neighbor[1];
                long newDist = dist[u] + w;

                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u];
                    pq.offer(new long[]{newDist, v});
                } 
               else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }
        
        return ways[V - 1];
    }
}
