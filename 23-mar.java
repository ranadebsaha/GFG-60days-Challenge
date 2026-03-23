//Length of Longest Cycle in a Graph
class Solution {
    public int longestCycle(int V, int[][] edges) {
        // code here
        int[] next = new int[V];
        for (int i = 0; i < V; i++) {
            next[i] = -1;
        }
        
        for (int[] e : edges) {
            next[e[0]] = e[1];
        }
            
        int[] visited = new int[V];
        int ans = -1;
        int timer = 1;
        
        for (int i = 0; i < V; i++) {
            if (visited[i] != 0) continue;
            
            int cur = i;
            int start = timer;
            while (cur != -1 && visited[cur] == 0) {
                visited[cur] = timer++;
                cur = next[cur];
            }
            if (cur != -1 && visited[cur] >= start) {
                ans = Math.max(ans, timer - visited[cur]);
            }
        }
        return ans;
    }
}
