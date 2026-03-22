//Rotten Oranges
class Solution {
    static boolean isSafe(int i, int j, int n, int m) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }

    public int orangesRot(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();

        int elapsedTime = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!q.isEmpty()) {
            int size = q.size();
            boolean flag = false; 

            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];

                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (isSafe(nx, ny, n, m) && mat[nx][ny] == 1) {
                        mat[nx][ny] = 2;
                        q.add(new int[]{nx, ny});
                        flag = true;
                    }
                }
            }

            if (flag)
                elapsedTime++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1)
                    return -1;
            }
        }

        return elapsedTime;
    }
}
