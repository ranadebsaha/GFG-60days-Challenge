//Course Schedule I
class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        // code here
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            int dest = pre[0];
            int src = pre[1];
            graph.get(src).add(dest);
            inDegree[dest]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (inDegree[i] == 0)
                q.add(i);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int child : graph.get(node)) {
                inDegree[child]--;
                if (inDegree[child] == 0)
                    q.add(child);
            }
        }
        for (int i = 0; i < n; i++)
            if (inDegree[i] != 0)
                return false;

        return true;
    }
}
